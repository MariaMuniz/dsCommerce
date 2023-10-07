package com.projeto.dscommerce.dto;

import com.projeto.dscommerce.entities.OrderItem;

public class OrderItemsDTO {
private Long prodctId;
private String name;
private Double price;
private Integer quantity;
public OrderItemsDTO(Long prodctId, String name, Double price, Integer quantity) {

	this.prodctId = prodctId;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
}

public OrderItemsDTO(OrderItem entity) {

	prodctId = entity.getProduct().getId();
	name = entity.getProduct().getName();
    price = entity.getPrice();
	quantity = entity.getQuantity();
}

public Long getProdctId() {
	return prodctId;
}

public String getName() {
	return name;
}

public Double getPrice() {
	return price;
}

public Integer getQuantity() {
	return quantity;
}
public Double getSubTotal() {
	return price * quantity;
}
}
