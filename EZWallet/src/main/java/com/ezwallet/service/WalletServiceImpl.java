package com.ezwallet.service;

import java.math.BigDecimal;
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
			Wallet wallet = new Wallet();
			wallet.setBalance(BigDecimal.valueOf(0));
			wallet.setCustomer(customer);
			return walletRepo.save(wallet).getCustomer();
			
		}
		
	}

	@Override
	public BigDecimal showWalletBalance(String mobileNumber) throws CustomerException {
		
		List<Customer> cust = customerRepo.findCustomerByMobile(mobileNumber);
		
		if(cust.isEmpty()) throw new CustomerException("Customer does not exist. Please create account");
		
		else {
			
			Integer id = cust.get(0).getCustomerId();
			return customerRepo.showWalletBalance(id);
		}
		
		
	}
	
	

}
