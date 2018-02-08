package com.todayfarmer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todayfarmer.domain.CropCategory;

public interface CropCategoryRepository extends JpaRepository<CropCategory, Integer>  {
	List<CropCategory> findAllByOrderByName();
}
