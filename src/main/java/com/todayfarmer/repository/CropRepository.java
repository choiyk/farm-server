package com.todayfarmer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todayfarmer.domain.Crop;

public interface CropRepository extends JpaRepository<Crop, Integer>  {
	List<Crop> findAllByOrderByName();
	List<Crop> findByCropCategoryIdOrderByName(int id);
}
