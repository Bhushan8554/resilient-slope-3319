package com.ezwallet.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BeneficiaryDTO {

	@NotNull
	@Pattern(regexp = "[789]{1}\\d{9}" , message = "Mobile number is not valid")
	private String mobileNumber;
	
	@NotNull
	@Size(min = 3,max = 15, message = "User Name is not valid")
	private String name;
	
}
