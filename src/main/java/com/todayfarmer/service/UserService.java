package com.todayfarmer.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todayfarmer.domain.APIResult;
import com.todayfarmer.domain.Farming;
import com.todayfarmer.domain.MyCrop;
import com.todayfarmer.domain.Pagination;
import com.todayfarmer.domain.Type;
import com.todayfarmer.domain.User;
import com.todayfarmer.repository.FarmingRepository;
import com.todayfarmer.repository.MyCropRepository;
import com.todayfarmer.repository.TypeRepository;
import com.todayfarmer.repository.UserRepository;

@Service
public class UserService {
	@Autowired UserRepository userRepository;
	@Autowired TypeRepository typeRepository;
	@Autowired MyCropRepository myCropRepository;
	@Autowired FarmingRepository farmingRepository;

	//user
	public User user(int id){
		return userRepository.findOne(id);
	}

	public User userByEmail(String email){
		return userRepository.findOneByEmail(email);
	}

	public User userByNickname(String nickname){
		return userRepository.findOneByNickname(nickname);
	}

	public boolean existEmail(String email){
		if(userByEmail(email)!=null) return true;
		else return false;
	}

	public boolean existNickname(String nickname){
		if(userByNickname(nickname)!=null) return true;
		else return false;
	}

	public APIResult login(User user){
		User find  = userRepository.findOneByEmail(user.getEmail());
		if(find == null){
			return new APIResult(false, "존재하지 않는 이메일입니다.");
		}
		else {
			if(!find.getPw().equals(user.getPw())) return new APIResult(false, "비밀번호가 틀립니다.");
			else return new APIResult(true, "로그인되었습니다.", find);
		}
	}

	public APIResult saveUser(User user){
		if(user.getId()>0)
			userRepository.save(user);
		else{
			if(existEmail(user.getEmail()))
				return new APIResult(false, "이미 존재하는 이메일입니다.");
			else if(existNickname(user.getNickname()))
				return new APIResult(false, "이미 존재하는 닉네임입니다.");
			userRepository.save(user);
		}
		return new APIResult(true);
	}

	//type
	public List<Type> types(){
		return typeRepository.findAll();
	}

	public Type type(int id){
		return typeRepository.findOne(id);
	}

	//myCrop
	public List<MyCrop> myCrops(int userid){
		return myCropRepository.findAllByUserId(userid);
	}

	public MyCrop myCrop(int id){
		return myCropRepository.findOne(id);
	}

	public String saveMyCrop(MyCrop myCrop){
		myCropRepository.save(myCrop);
		return "저장되었습니다.";
	}

	public String deleteMyCrop(int id){
		farmingRepository.deleteByMyCropId(id);
		myCropRepository.delete(id);
		return "삭제되었습니다.";
	}

	//farming
//	public List<Farming> farming(int id){
//		return farmingRepository.findAllByUserId(id);
//	}
//
//	public List<Farming> farming(int userId, int myCropId){
//		return farmingRepository.findAllByUserIdAndMyCropId(userId, myCropId);
//	}
	public List<Farming> farming(Pagination pagination){
		return farmingRepository.findAll(pagination);
	}

	public Farming farming(int id){
		return farmingRepository.findOne(id);
	}

	public String saveFarming(Farming farming){
		farming.setPostDate(currentDate());
		farmingRepository.save(farming);
		return "저장되었습니다.";
	}

	public String deleteFarming(int id){
		farmingRepository.delete(id);
		return "삭제되었습니다.";
	}

//	public List<Farming> farmingByDate(String date, int userId){
//		return farmingRepository.findByDate(date, userId);
//	}

	//etc
	public String currentDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(new Date());
	}

}
