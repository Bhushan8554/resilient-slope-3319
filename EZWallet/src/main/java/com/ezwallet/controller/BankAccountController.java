package com.ezwallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezwallet.exception.BankAccountException;
import com.ezwallet.model.BankAccount;
import com.ezwallet.model.Wallet;
import com.ezwallet.service.BankAccountService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/bankaccount")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@GetMapping("/bankaccount")
	public ResponseEntity<BankAccount> getBankAccountMapping(@RequestBody Wallet wallet) throws BankAccountException{
		BankAccount bacc=bankAccountService.viewAccount(wallet);
		
		
		ResponseEntity<BankAccount> resBacc= new ResponseEntity<>(bacc,HttpStatus.FOUND);
		
		return resBacc;
		
		
	}

	@GetMapping("/bankaccounts")
	public ResponseEntity<List<BankAccount>> getAllBankAccountMapping(@RequestBody Wallet wallet) throws BankAccountException{
		
		List<BankAccount> listBacc= bankAccountService.viewAllAccount(wallet);
		
		ResponseEntity<List<BankAccount>> resListBacc= new ResponseEntity<>(listBacc,HttpStatus.FOUND);
		
		return resListBacc;
		
	}
	
	
	@PostMapping("/bankaccount")
	public ResponseEntity<Wallet> addAccountMapping(@RequestBody BankAccount bankAccount) throws BankAccountException{
		
		Wallet wallet= bankAccountService.addAccount(bankAccount);
		
		ResponseEntity<Wallet> resWallet= new ResponseEntity<>(wallet,HttpStatus.ACCEPTED);
		
		return resWallet;
	}
	
	@DeleteMapping("/bankaccount")
	public ResponseEntity<Wallet> removeAccountMapping(@RequestBody BankAccount bankAccount) throws BankAccountException{
		
		Wallet wallet= bankAccountService.removeAccount(bankAccount);
		
		ResponseEntity<Wallet> resWallet= new ResponseEntity<>(wallet,HttpStatus.OK);
		
		
		return resWallet;
	}
	
	
	
	
	
	
	
	

}
