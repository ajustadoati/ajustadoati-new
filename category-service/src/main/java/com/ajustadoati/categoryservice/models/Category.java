package com.ajustadoati.categoryservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author richardroj
 *
 */
@Entity
@Table(name="category")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	@Column(name="google_place_type")
	private String googlePlaceType;
}
