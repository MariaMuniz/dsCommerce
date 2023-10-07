package com.projeto.dscommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.dscommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
	
}
