package com.ajustadoati.categoryservice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ajustadoati.categoryservice.models.Category;

public interface ICategoryRepository extends CrudRepository<Category, Long> {

}
