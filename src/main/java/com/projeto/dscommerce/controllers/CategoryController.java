package com.projeto.dscommerce.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.dscommerce.dto.CategoryDTO;
import com.projeto.dscommerce.services.CategoryService;


@RestController
@RequestMapping(value ="/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	

	@GetMapping
	public ResponseEntity <List<CategoryDTO>> findAll(){
		List<CategoryDTO>list = service.findAll();
	 return ResponseEntity.ok(list);
	}
	
   
	
}