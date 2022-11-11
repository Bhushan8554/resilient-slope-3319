package com.ezwallet.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezwallet.exception.BankAccountException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.exception.WalletException;
import com.ezwallet.model.Customer;
import com.ezwallet.service.WalletService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/CustomerWallet")
public class CustomerWalletController {
	
	@Autowired
	public WalletService walletService;

	@PostMapping("/createaccount")
	public ResponseEntity<Customer> createAccount(@Valid @RequestBody Customer customer) throws CustomerException{
		
		Customer cust = walletService.createCustomerAccount(customer);
		
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
	}
	
	@PostMapping("/transfermoneyfrombanktowallet/{accountno}/{amount}")
	public ResponseEntity<String> transferMoneyFromBankToWallet(@PathVariable("accountno") Integer accountNo, @PathVariable("amount") Double amount) throws BankAccountException, CustomerException{
		
		String msg = walletService.addMoneyFromBankToWallet(accountNo, amount);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
	@PostMapping("/fundtransfer/{mobile}/{name}/{amount}")
	public ResponseEntity<String> fundtransfer(@PathVariable("mobile") String mobile, @PathVariable("name") String name, @PathVariable("amount") BigDecimal amount) throws WalletException, CustomerException{
		
		String msg = walletService.fundTransferToAnotherMobileNumber(mobile, name, amount);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
	
}
