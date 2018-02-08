package com.todayfarmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todayfarmer.domain.APIResult;
import com.todayfarmer.domain.Crop;
import com.todayfarmer.domain.CropCategory;
import com.todayfarmer.domain.Farming;
import com.todayfarmer.domain.MyCrop;
import com.todayfarmer.domain.Pagination;
import com.todayfarmer.domain.Type;
import com.todayfarmer.domain.User;
import com.todayfarmer.service.CropService;
import com.todayfarmer.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class APIController {

	@Autowired UserService userService;
	@Autowired CropService cropService;

	//회원가입
	@RequestMapping(value="user", method=RequestMethod.POST)
	public APIResult saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}

	//로그인
	@RequestMapping(value="login", method=RequestMethod.POST)
	public APIResult login(@RequestBody User user){
		return userService.login(user);
	}

	@RequestMapping(value="user/{id}")
	public User user(@PathVariable("id") int id){
		return userService.user(id);
	}

	@RequestMapping(value="userEmail", method=RequestMethod.POST)	//value="userEmail/{email:.+}"
	public User userByEmail(@RequestBody String email){
		User user = userService.userByEmail(email);
		return user;
	}

	//Type
	@RequestMapping(value="types")
	public List<Type> types(){
		return userService.types();
	}

	@RequestMapping(value="type/{id}")
	public Type type(@PathVariable("id") int id){
		return userService.type(id);
	}

	//MyCrop
	@RequestMapping(value="myCrops/{userid}")
	public List<MyCrop> myCrops(@PathVariable("userid") int userid){
		return userService.myCrops(userid);
	}

	@RequestMapping(value="myCrop/{id}")
	public MyCrop myCrop(@PathVariable("id") int id){
		return userService.myCrop(id);
	}

	@RequestMapping(value="myCrop", method=RequestMethod.POST)
	public String saveMyCrop(@RequestBody MyCrop myCrop){
		return userService.saveMyCrop(myCrop);
	}

	@RequestMapping(value="myCrop/{id}", method=RequestMethod.DELETE)
	public String deleteMyCrop(@PathVariable("id") int id){
		return userService.deleteMyCrop(id);
	}

	//Farming
	@RequestMapping(value="farming/{id}")
	public Farming farming(@PathVariable("id") int id){
		return userService.farming(id);
	}
//
//	@RequestMapping(value="farming/{id}/{myCrop}")
//	public List<Farming> farming(@PathVariable("id") int userId, @PathVariable("myCrop") int myCropId){
//		return userService.farming(userId, myCropId);
//	}
	@RequestMapping(value="farmings", method=RequestMethod.POST)
	public List<Farming> farming(@RequestBody Pagination pagination){
		return userService.farming(pagination);
	}

	@RequestMapping(value="farming", method=RequestMethod.POST)
	public String saveFarming(@RequestBody Farming farming){
		return userService.saveFarming(farming);
	}

	@RequestMapping(value="farming/{id}", method=RequestMethod.DELETE)
	public String deleteFarming(@PathVariable("id") int id){
		return userService.deleteFarming(id);
	}

	//CropCategory
	@RequestMapping(value="cropCategories")
	public List<CropCategory> cropCategories(){
		return cropService.cropCategories();
	}

	//Crop
	@RequestMapping(value="crops")
	public List<Crop> crops(){
		return cropService.crops();
	}

	@RequestMapping(value="crops/{category}")
	public List<Crop> crop(@PathVariable("category") int category){
		return cropService.crops(category);
	}

}
