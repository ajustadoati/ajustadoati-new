package com.ajustadoati.categoryservice.controllers.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import com.ajustadoati.categoryservice.exceptions.ErrorResponse;
import com.ajustadoati.categoryservice.models.Category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface ICategoryController{
	
	public List<Category> getCategories();
	
	@Operation(summary = "/saveCategory", description = "Operation to save category.", tags = "Category")
    @ApiResponse(responseCode = "201", description = "Created category succeed",
            content = @Content(schema = @Schema(implementation = Category.class)))
    @ApiResponse(responseCode = "400", description = "Category validations don't succeed ",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @PostMapping(value = "/category",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> saveCategory(@RequestBody Category category);
	
	@DeleteMapping(path = "/category/{id}")
	public ResponseEntity<Category> deleteCategoryById(@PathVariable long id);

}
