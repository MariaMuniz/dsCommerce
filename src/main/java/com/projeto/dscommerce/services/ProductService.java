package com.projeto.dscommerce.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.dscommerce.dto.ProductDTO;
import com.projeto.dscommerce.entities.Product;
import com.projeto.dscommerce.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
	
		Product product = repository.findById(id).get();
		return new ProductDTO(product);
	
	
	}
	
}
