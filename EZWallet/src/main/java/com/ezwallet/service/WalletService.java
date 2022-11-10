package com.ezwallet.service;

import com.ezwallet.exception.CustomerException;
import com.ezwallet.model.Customer;

public interface WalletService {

	public Customer createCustomerAccount(Customer customer) throws CustomerException;
}
