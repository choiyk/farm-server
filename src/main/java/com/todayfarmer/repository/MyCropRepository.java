package com.todayfarmer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todayfarmer.domain.MyCrop;

public interface MyCropRepository extends JpaRepository<MyCrop, Integer>  {
	List<MyCrop> findAllByUserId(int id);
}
