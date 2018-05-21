package com.todayfarmer.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.todayfarmer.domain.Farming;
import com.todayfarmer.domain.Pagination;

public interface FarmingRepository extends JpaRepository<Farming, Integer>  {
	List<Farming> findAllByUserId(int id, Pageable pageable);
	List<Farming> findAllByUserIdAndMyCropId(int userId, int myCropId, Pageable pageable);
	List<Farming> findAllByUserIdAndAlarm(int userId, int alarm, Pageable pageable);
	List<Farming> findAllByUserIdAndMyCropIdAndAlarm(int userId, int myCropId, int alarm, Pageable pageable);

	void deleteByMyCropId(int id);

	@Query("SELECT f FROM Farming f WHERE userId= :userId and function('date_format', postDate, '%m-%d')= :date")
	List<Farming> findByUserIdAndDate(@Param("date") String date, @Param("userId") int userId, Pageable pageable);

	@Query("SELECT f FROM Farming f WHERE userId= :userId and cropId= :myCropId and function('date_format', postDate, '%m-%d')= :date")
	List<Farming> findByUserIdAndDateAndMyCropId(@Param("date") String date, @Param("userId") int userId, @Param("myCropId") int myCropId, Pageable pageable);

	@Query("SELECT f FROM Farming f WHERE userId= :userId and alarm= :alarm and function('date_format', postDate, '%m-%d')= :date")
	List<Farming> findByUserIdAndDateAndAlarm(@Param("date") String date, @Param("userId") int userId, @Param("alarm") int alarm, Pageable pageable);

	@Query("SELECT f FROM Farming f WHERE userId= :userId and cropId= :myCropId and alarm= :alarm and function('date_format', postDate, '%m-%d')= :date")
	List<Farming> findByUserIdAndDateAndMyCropIdAndAlarm(@Param("date") String date, @Param("userId") int userId, @Param("myCropId") int myCropId, @Param("alarm") int alarm, Pageable pageable);

	public default List<Farming> findAll(Pagination pagination){
		Pageable pageable = new PageRequest(pagination.getPg()-1, pagination.getSz());

		if(pagination.getAb()==0){
			if(pagination.getCi()==0)
				return findByUserIdAndDate(pagination.getDate(), pagination.getUi(), pageable);
			else
				return findByUserIdAndDateAndMyCropId(pagination.getDate(), pagination.getUi(), pagination.getCi(), pageable);
		}
		else{
			if(pagination.getCi()==0)
				return findByUserIdAndDateAndAlarm(pagination.getDate(), pagination.getUi(), pagination.getAb(), pageable);
			else
				return findByUserIdAndDateAndMyCropIdAndAlarm(pagination.getDate(), pagination.getUi(), pagination.getCi(), pagination.getAb(), pageable);
		}

//		if(pagination.getAb()==0 && pagination.getDate()!=null){
//			System.out.println("date: "+pagination.getDate());
//			return findByUserIdAndDate(pagination.getDate(), pagination.getUi());
//		}
//		else if(pagination.getAb()==0 && pagination.getCi()==0){
//			System.out.println("findAllByUserId");
//			return findAllByUserId(pagination.getUi(), pageable);
//		}
//		else if(pagination.getAb()==0){
//			System.out.println("findAllByUserIdAndMyCropId");
//			return findAllByUserIdAndMyCropId(pagination.getUi(), pagination.getCi(), pageable);
//		}
//		else if(pagination.getAb()==1 && pagination.getCi()==0){
//			System.out.println("findAllByUserIdAndAlarm");
//			return findAllByUserIdAndAlarm(pagination.getUi(), 1, pageable);
//		}
//		else{
//			System.out.println("findAllByUserIdAndMyCropIdAndAlarm");
//			return findAllByUserIdAndMyCropIdAndAlarm(pagination.getUi(), pagination.getCi(), 1, pageable);
//		}
	}
}
