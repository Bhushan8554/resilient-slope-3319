package com.ezwallet.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;


@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	private String transactionType;
	private LocalDate transactionDate;
	private double amount;
	private String Description;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(Integer transactionId, String transactionType, LocalDate transactionDate, double amount,
			String description) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.amount = amount;
		Description = description;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public String getDescription() {
		return Description;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactionDate=" + transactionDate + ", amount=" + amount + ", Description=" + Description + "]";
	}
	
	
	

}
