package com.ezwallet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezwallet.exception.BankAccountException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.model.BankAccount;
import com.ezwallet.model.BankAccountDTO;
import com.ezwallet.model.Wallet;
import com.ezwallet.service.BankAccountService;


@RestController
@RequestMapping("/bankservice")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
//	@GetMapping("/getbankaccount")
//	public ResponseEntity<BankAccount> getBankAccountMapping(@RequestParam String key) throws BankAccountException, CustomerException{
//		BankAccount bacc=bankAccountService.viewAccount(key);	
//		ResponseEntity<BankAccount> resBacc= new ResponseEntity<>(bacc,HttpStatus.ACCEPTED);
//		return resBacc;
//			
//	}

	
	
	@GetMapping("/bankaccounts")
	public ResponseEntity<List<BankAccount>> getAllBankAccountMapping(@RequestParam String key) throws BankAccountException, CustomerException{
		
		List<BankAccount> listBacc= bankAccountService.viewAllAccount(key);
		
		
		
		ResponseEntity<List<BankAccount>> resListBacc= new ResponseEntity<>(listBacc,HttpStatus.FOUND);
		
		return resListBacc;
		
	}
	
	
	@PostMapping("/addbankaccount")
	public ResponseEntity<String> addAccountMapping(@RequestParam String key,@Valid @RequestBody BankAccountDTO bankAccount) throws BankAccountException, CustomerException{
		
		Wallet wallet= bankAccountService.addAccount(key,bankAccount);
		
		ResponseEntity<String> resWallet= new ResponseEntity<>("Bank Account Added Succssesfuly",HttpStatus.ACCEPTED);
		
		return resWallet;
	}

	
	
	@DeleteMapping("/deletebank")
	public ResponseEntity<Wallet> removeAccountMapping(@RequestParam String key,@Valid @RequestBody BankAccountDTO bankAccount) throws BankAccountException{
		
		Wallet wallet= bankAccountService.removeAccount(key,bankAccount);
		
		ResponseEntity<Wallet> resWallet= new ResponseEntity<>(wallet,HttpStatus.OK);
		
		
		return resWallet;
	}
	
	
	
	
	
	
	
	

}
