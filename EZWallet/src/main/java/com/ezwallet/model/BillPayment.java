package com.ezwallet.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	
	private Double amount;
	
	private String billType;
	
	@CreatedDate
	@CreationTimestamp
	private LocalDate paymentDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	
	
}
