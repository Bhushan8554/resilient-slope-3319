package com.ezwallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Beneficiary {

	@Id
	@NotNull
	@Pattern(regexp = "[789]{1}\\d{9}" , message = "Mobile number is not valid")
	private String mobileNumber;
	
	@NotNull
	@Pattern(regexp = "[^0-9.]{3,30}" , message = "User Name is not valid")
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "walletId" ,referencedColumnName = "walletId")
	private Wallet wallet;
	
	
}
