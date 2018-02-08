package com.todayfarmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todayfarmer.domain.Crop;
import com.todayfarmer.domain.CropCategory;
import com.todayfarmer.repository.CropCategoryRepository;
import com.todayfarmer.repository.CropRepository;

@Service
public class CropService {
	@Autowired CropCategoryRepository cropCategoryRepository;
	@Autowired CropRepository cropRepository;

	public List<CropCategory> cropCategories(){
		return cropCategoryRepository.findAllByOrderByName();
	}

	public List<Crop> crops(){
		return cropRepository.findAllByOrderByName();
	}

	public List<Crop> crops(int category){
		return cropRepository.findByCropCategoryIdOrderByName(category);
	}

}
