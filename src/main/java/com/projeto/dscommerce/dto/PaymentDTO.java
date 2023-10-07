package com.projeto.dscommerce.dto;

import java.time.Instant;

import com.projeto.dscommerce.entities.Payment;

import jakarta.persistence.Column;

public class PaymentDTO {

	private Long id;
    private Instant moment;
    
  

	public PaymentDTO(Long id, Instant moment) {
		this.id = id;
		this.moment = moment;
	}
    
	public PaymentDTO(Payment entity) {
		id = entity.getId();
		moment = entity.getMoment();
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

}
