package com.ezwallet.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Data;

@Data

public class TransactionDTO {
	
	private Integer transactionId;
	private String transactionType;
	private LocalDate transactionDate;
	private double amount;
	private String Description;

}
