package com.ezwallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezwallet.exception.CustomerException;
import com.ezwallet.model.Customer;
import com.ezwallet.model.Wallet;
import com.ezwallet.repository.CustomerRepository;
import com.ezwallet.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService{
	
	@Autowired
	public CustomerRepository customerRepo; 
	
	@Autowired
	public WalletRepository walletRepo;

	@Override
	public Customer createCustomerAccount(Customer customer) throws CustomerException {
		
		List<Customer> cust = customerRepo.findCustomerByMobile(customer.getMobileNumber());
		
		if(!cust.isEmpty()) throw new CustomerException("This mobile number is already registered with EZWallet");
		
		else  {			
			return customerRepo.save(customer);
		}
		
	}

}
