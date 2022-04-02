package com.ajustadoati.categoryservice.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;

import com.ajustadoati.categoryservice.config.CategoryFactoryDataMock;
import com.ajustadoati.categoryservice.config.H2JpaConfig;
import com.ajustadoati.categoryservice.models.Category;
import com.ajustadoati.categoryservice.repositories.ICategoryRepository;
import com.ajustadoati.categoryservice.services.CategoryService;

@SpringBootTest(classes = { CategoryService.class, ICategoryRepository.class })
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@Import({ H2JpaConfig.class })
public class CategoryServiceTests {
	
	@Autowired
	CategoryService categoryService;
	
	
	@Autowired
	ICategoryRepository iCategoryRepository;
	
	private List<Category> insertMockData() {
		return (List<Category>) iCategoryRepository
				.saveAll(CategoryFactoryDataMock.createCategoryList());
	}
	
	@Test
	@DisplayName("CategoryService:findAllCategories")
	public void findAllCategories() {
		List<Category> categories = this.insertMockData();
		List<Category> current = categoryService.categoryList();
		Assertions.assertNotNull(categories);
		Assertions.assertEquals(categories.size(), 2);
		Assertions.assertEquals(current.get(1).getName(), categories.get(1).getName());
	}
	

}
