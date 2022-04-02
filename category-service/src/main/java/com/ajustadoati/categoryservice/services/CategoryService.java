package com.ajustadoati.categoryservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajustadoati.categoryservice.models.Category;
import com.ajustadoati.categoryservice.repositories.ICategoryRepository;
/**
 * 
 * @author richardroj
 *
 */
@Service
public class CategoryService {
	
	private final Logger log = Logger.getLogger(getClass().getName());
	
	@Autowired
	ICategoryRepository categoryRepository;
	
	public List<Category> categoryList(){
		log.info("Service: list");
		List<Category> list = new ArrayList<Category>();
		Iterable<Category> result = categoryRepository.findAll();
		result.forEach(list::add);
		
		
		return list;
	}
	
	public void save(Category category) {
		log.info("Service: save category" +category);
		categoryRepository.save(category);
	}
	
	public Category deleteCategory(long id) {
		log.info("Service: delete category" +id);
		Optional<Category> opt = categoryRepository.findById(id);
		
		
		if(opt.isPresent()) {
			categoryRepository.deleteById(id);
			return opt.get();
		}
		return null;
	}

}
