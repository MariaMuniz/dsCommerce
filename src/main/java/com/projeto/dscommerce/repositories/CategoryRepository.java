package com.projeto.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.dscommerce.entities.Category;
import com.projeto.dscommerce.entities.Product;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
}
