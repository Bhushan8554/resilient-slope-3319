package com.ezwallet.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BankAccountDTO {
	
	
	@NotNull
	private Integer accountNo;
	
	@NotNull
	@Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$" , message = "IFSC must be valid")
	private String IFSCCode;
	
	@NotNull
	@Size(min = 4, max = 10,message = "Bank name not valid")
	private String bankName;
	
	@NotNull
	private Double balance;
	
	
	

}
