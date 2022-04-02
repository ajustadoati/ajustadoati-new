package com.ajustadoati.categoryservice.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajustadoati.categoryservice.models.Category;
import com.ajustadoati.categoryservice.services.CategoryService;
/**
 * 
 * @author richardroj
 *
 */
@RestController
public class CategoryController {
	
	private final Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	CategoryService categoryService;
	
	@GetMapping(path = "category")
	public List<Category> getCategories(){
		log.info("Controller: category list");
		categoryService.categoryList();
		return categoryService.categoryList();
	}
	
	@PostMapping(path = "category")
	public ResponseEntity<Object> saveCategory(@RequestBody Category category) {
		log.info("Controller: save category"+category);
		categoryService.save(category);
		
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "category/{id}")
	public ResponseEntity<Category> deleteCategoryById(@PathVariable long id){
		
		Category cat = categoryService.deleteCategory(id);
		if (cat != null)
			return new ResponseEntity<Category>(cat, HttpStatus.OK);
		else
			return new ResponseEntity<Category>(cat, HttpStatus.NOT_FOUND);
	}
}
