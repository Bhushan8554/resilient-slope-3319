package com.ezwallet.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezwallet.exception.TransactionException;
import com.ezwallet.exception.WalletException;
import com.ezwallet.model.Transaction;
import com.ezwallet.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService trService;
	
	@PostMapping("/transaction")
	public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction tran) throws TransactionException, WalletException{
		Transaction tr= trService.addTransaction(tran);
		
	return new	ResponseEntity<Transaction>(tr,HttpStatus.ACCEPTED);
			
	}
	
	@GetMapping("/transactionn")
	public ResponseEntity<List<Transaction>> viewAllTransaction(@RequestParam LocalDate from,@RequestParam(required = false) LocalDate to) throws TransactionException{
		
		List<Transaction> allList=	trService.viewTransactionByDate(from, to);
	
		return new ResponseEntity<List<Transaction>>(allList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/alltransaction/{transactionType}")
	public ResponseEntity<List<Transaction>> viewAllTransacationByType(@PathVariable("transactionType") String type) throws TransactionException{
		
		List<Transaction> allList=trService.viewAllTransactionByType(type);
		
		return new ResponseEntity<List<Transaction>>(allList,HttpStatus.ACCEPTED);
	}

}
