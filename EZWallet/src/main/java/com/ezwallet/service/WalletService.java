package com.ezwallet.service;

import java.math.BigDecimal;

import com.ezwallet.exception.CustomerException;
import com.ezwallet.model.Customer;

public interface WalletService {

	public Customer createCustomerAccount(Customer customer) throws CustomerException;
	
	public BigDecimal showWalletBalance(String mobileNumber) throws CustomerException;
}
