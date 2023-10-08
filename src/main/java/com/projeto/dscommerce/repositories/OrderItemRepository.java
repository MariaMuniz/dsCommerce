package com.projeto.dscommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.dscommerce.entities.OrderItem;
import com.projeto.dscommerce.entities.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

	
	
}
