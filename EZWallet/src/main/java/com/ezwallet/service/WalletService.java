package com.ezwallet.service;

import java.math.BigDecimal;

import com.ezwallet.exception.BankAccountException;
import com.ezwallet.exception.BeneficiaryException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.exception.WalletException;
import com.ezwallet.model.Customer;

public interface WalletService {

	public Customer createCustomerAccount(Customer customer) throws CustomerException;
	
	public BigDecimal showWalletBalance(String mobileNumber) throws CustomerException;
	
	public String addMoneyFromBankToWallet(Integer accountNo, Double amount) throws BankAccountException, CustomerException;
	
	public String fundTransferToAnotherMobileNumber(String targetMobile, String name, BigDecimal amount) throws WalletException, CustomerException;
}
