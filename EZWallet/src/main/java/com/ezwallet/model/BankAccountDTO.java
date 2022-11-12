package com.ezwallet.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BankAccountDTO {
	
	
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
	
	

}
