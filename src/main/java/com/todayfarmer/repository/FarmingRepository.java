package com.todayfarmer.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.todayfarmer.domain.Farming;
import com.todayfarmer.domain.Pagination;

public interface FarmingRepository extends JpaRepository<Farming, Integer>  {
	List<Farming> findAllByUserId(int id, Pageable pageable);
	List<Farming> findAllByUserIdAndMyCropId(int userId, int myCropId, Pageable pageable);
	List<Farming> findAllByUserIdAndAlarm(int userId, int alarm, Pageable pageable);
	List<Farming> findAllByUserIdAndMyCropIdAndAlarm(int userId, int myCropId, int alarm, Pageable pageable);

	void deleteByMyCropId(int id);

	public default List<Farming> findAll(Pagination pagination){
		Pageable pageable = new PageRequest(pagination.getPg()-1, pagination.getSz());

		if(pagination.getAb()==0 && pagination.getSb()==0)
			return findAllByUserId(pagination.getUi(), pageable);
		else if(pagination.getAb()==0)
			return findAllByUserIdAndMyCropId(pagination.getUi(), pagination.getSb(), pageable);
		else if(pagination.getAb()==1 && pagination.getSb()==0)
			return findAllByUserIdAndAlarm(pagination.getUi(), 1, pageable);
		else
			return findAllByUserIdAndMyCropIdAndAlarm(pagination.getUi(), pagination.getSb(), 1, pageable);
	}
}
