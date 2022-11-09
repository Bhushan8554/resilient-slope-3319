package com.ezwallet.service;

import java.util.List;

import com.ezwallet.model.Beneficiary;

public interface BeneficiaryService {

	
	public Beneficiary addBeneficiary(Beneficiary beneficiary);
	
	public Beneficiary deleteBeneficiary(Beneficiary beneficiary);
	
	public Beneficiary viewBeneficiary(String name);
	
	public List<Beneficiary> viewAllBeneficiary(Beneficiary beneficiary);
}
