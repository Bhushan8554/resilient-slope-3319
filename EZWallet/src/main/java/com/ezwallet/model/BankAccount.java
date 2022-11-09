package com.ezwallet.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankAccount {

	@Id
	@NotNull
	private Integer accountNo;
	
	@NotNull
	@Size(min = 4, max = 10,message = "IFSC not valid")
	private String IFSCCode;
	
	@NotNull
	@Size(min = 4, max = 10,message = "IFSC not valid")
	private String bankName;
	
	@NotNull
	private Double balance;
	
	private Wallet wallet;
	
}
