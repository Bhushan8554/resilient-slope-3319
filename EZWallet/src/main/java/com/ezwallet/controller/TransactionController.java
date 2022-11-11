package com.ezwallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezwallet.exception.TransactionException;
import com.ezwallet.exception.WalletException;
import com.ezwallet.model.Transaction;
import com.ezwallet.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	
	
	
	@PostMapping("/transaction")
	public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction tran) throws TransactionException, WalletException{
		Transaction tr= transactionService.addTransaction(tran);
		return new	ResponseEntity<Transaction>(tr,HttpStatus.ACCEPTED);	
	}
	
	
	
	
//	@GetMapping("/transaction")
//	public ResponseEntity<List<Transaction>> viewAllTransaction(@RequestParam LocalDate from,@RequestParam(required = false) LocalDate to) throws TransactionException{
//		List<Transaction> allList=	transactionService.viewTransactionByDate(from, to);
//		return new ResponseEntity<List<Transaction>>(allList,HttpStatus.ACCEPTED);
//	}
	
	
	
	
	@GetMapping("/transactiontype/{type}")
	public ResponseEntity<List<Transaction>> viewAllTransacationByType(@PathVariable("type") String type) throws TransactionException{
		List<Transaction> allList=transactionService.findByTransactionType(type);
		return new ResponseEntity<List<Transaction>>(allList,HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/transaction/{id}")
	public ResponseEntity<Transaction> findById(@PathVariable("id") Integer id) throws TransactionException{
		Transaction transaction = transactionService.findByTransactionId(id);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
	}
	
	

}
