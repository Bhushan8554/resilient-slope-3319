package com.ezwallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezwallet.exception.BankAccountException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.model.BankAccount;
import com.ezwallet.model.BankAccountDTO;
import com.ezwallet.model.Wallet;
import com.ezwallet.service.BankAccountService;


@RestController
@RequestMapping("/bank")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@PostMapping("/bankacc/{key}")
	public ResponseEntity<BankAccount> getBankAccountMapping(@PathVariable String key, @RequestBody Wallet wallet) throws BankAccountException, CustomerException{
		BankAccount bacc=bankAccountService.viewAccount(key,wallet);	
		ResponseEntity<BankAccount> resBacc= new ResponseEntity<>(bacc,HttpStatus.FOUND);
		return resBacc;
			
	}

	
	
	@PostMapping("/bankaccounts/{key}")
	public ResponseEntity<List<BankAccount>> getAllBankAccountMapping(@PathVariable String key, @RequestBody Wallet wallet) throws BankAccountException, CustomerException{
		
		List<BankAccount> listBacc= bankAccountService.viewAllAccount(key,wallet);
		
		ResponseEntity<List<BankAccount>> resListBacc= new ResponseEntity<>(listBacc,HttpStatus.FOUND);
		
		return resListBacc;
		
	}
	
	
	@PostMapping("/bankaccount/{key}")
	public ResponseEntity<Wallet> addAccountMapping(@PathVariable String key, @RequestBody BankAccountDTO bankAccount) throws BankAccountException, CustomerException{
		
		Wallet wallet= bankAccountService.addAccount(key,bankAccount);
		
		ResponseEntity<Wallet> resWallet= new ResponseEntity<>(wallet,HttpStatus.ACCEPTED);
		
		return resWallet;
	}

	
	
	@DeleteMapping("/deltebank")
	public ResponseEntity<Wallet> removeAccountMapping(@RequestBody BankAccount bankAccount) throws BankAccountException{
		
		Wallet wallet= bankAccountService.removeAccount(bankAccount);
		
		ResponseEntity<Wallet> resWallet= new ResponseEntity<>(wallet,HttpStatus.OK);
		
		
		return resWallet;
	}
	
	
	
	
	
	
	
	

}
