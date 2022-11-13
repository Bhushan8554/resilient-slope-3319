package com.ezwallet.service;

import java.util.List;

import com.ezwallet.exception.BeneficiaryException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.model.Beneficiary;
import com.ezwallet.model.BeneficiaryDTO;
import com.ezwallet.model.Wallet;

public interface BeneficiaryService {

	
	public Beneficiary addBeneficiary(Beneficiary beneficiary) throws BeneficiaryException;
	
	public Beneficiary deleteBeneficiary(String key,BeneficiaryDTO beneficiary) throws BeneficiaryException, CustomerException;
	
	public Beneficiary viewBeneficiary(String name,String key) throws BeneficiaryException, CustomerException;
	
	public List<Beneficiary> findAllByWallet(Wallet wallet) throws BeneficiaryException;
	
	public List<Beneficiary> viewAllBeneficiary(String key) throws BeneficiaryException, CustomerException;
}
