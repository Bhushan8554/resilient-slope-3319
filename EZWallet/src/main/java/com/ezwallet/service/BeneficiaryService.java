package com.ezwallet.service;

import java.util.List;

import com.ezwallet.exception.BeneficiaryException;
import com.ezwallet.model.Beneficiary;

public interface BeneficiaryService {

	
	public Beneficiary addBeneficiary(Beneficiary beneficiary) throws BeneficiaryException;
	
	public Beneficiary deleteBeneficiary(Beneficiary beneficiary) throws BeneficiaryException;
	
	public List<Beneficiary> viewBeneficiary(String name) throws BeneficiaryException;
	
	public List<Beneficiary> viewAllBeneficiary(Beneficiary beneficiary) throws BeneficiaryException;
}
