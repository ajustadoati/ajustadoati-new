package com.ajustadoati.categoryservice.controllers;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ajustadoati.categoryservice.config.CategoryFactoryDataMock;
import com.ajustadoati.categoryservice.controllers.CategoryController;
import com.ajustadoati.categoryservice.models.Category;
import com.ajustadoati.categoryservice.services.CategoryService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = { CategoryController.class })
public class CategoryControllerTests {
	//
	private MockMvc mockMvc;
	
	@Autowired
	CategoryController categoryController;
	
	@MockBean
	CategoryService categoryService;
	
	private final static ObjectMapper mapper = new ObjectMapper();
	
	@BeforeAll
	public static void setupClass() {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
	}
	
	@Test
	@DisplayName("CategoryController:getCategoryList:succeed")
	public void whenGetCategoryList_ShouldReturnsSucceed() throws Exception {
		// Stubbing
		List<Category> lpt = CategoryFactoryDataMock.createCategoryList();
		doReturn(lpt).when(categoryService).categoryList();

		var response = mockMvc
				.perform(MockMvcRequestBuilders.get("/category").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn().getResponse();

		List<Category> expected = mapper.readValue(response.getContentAsString(),
				new TypeReference<List<Category>>() {
				});
		assertEquals(expected.size(), lpt.size());
	}
	
	
}
