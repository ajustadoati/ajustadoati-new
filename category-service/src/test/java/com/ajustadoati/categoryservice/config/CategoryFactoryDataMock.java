package com.ajustadoati.categoryservice.config;

import java.util.List;

import com.ajustadoati.categoryservice.models.Category;

public interface CategoryFactoryDataMock {
	
	/**
	 * Create category list
	 * @return
	 */
	static List<Category> createCategoryList() {
		var cat1 = new Category();
		cat1.setName("Category-1");
		cat1.setDescription("Category-desc-1");
		cat1.setGooglePlaceType("Category-google-1");
		
		var cat2 = new Category();
		cat2.setName("Category-1");
		cat2.setDescription("Category-desc-1");
		cat2.setGooglePlaceType("Category-google-1");
		
		return List.of(cat1,cat2);
	}
}
