package com.projeto.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.projeto.dscommerce.entities.Order;
import com.projeto.dscommerce.entities.OrderItem;
import com.projeto.dscommerce.entities.enums.OrderStatus;

public class OrderDTO {
	private Long id;
    private Instant moment;
    private OrderStatus status;
    
    private ClientDTO client;
    private PaymentDTO payment;
    private List<OrderItemsDTO> items= new ArrayList<>();
	public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.payment = payment;
	}
    
	public OrderDTO(Order entity) {
		
		id =entity.getId();
		moment = entity.getMoment();
		status = entity.getStatus();
		client = new ClientDTO(entity.getClient());
		payment = (entity.getPayment()== null ) ?null : new PaymentDTO(entity.getPayment());
		for(OrderItem item : entity.getItems()) {
			OrderItemsDTO itemDTO = new OrderItemsDTO(item);
			items.add(itemDTO);
		}
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public ClientDTO getClient() {
		return client;
	}

	public PaymentDTO getPayment() {
		return payment;
	}

	public List<OrderItemsDTO> getItems() {
		return items;
	}
    
	public Double getTotal() {
		double sum=0.0;
		for (OrderItemsDTO item : items) {
			sum = sum+ item.getSubTotal();
		
		}
		return sum;
	}
}
