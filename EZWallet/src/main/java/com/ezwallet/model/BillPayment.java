package com.ezwallet.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.Id;

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
	
	private LocalDate paymentDate;
	
	private Wallet wallet;
}
