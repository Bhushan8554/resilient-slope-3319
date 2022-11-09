package com.ezwallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezwallet.exception.TransactionException;
import com.ezwallet.model.Transaction;
import com.ezwallet.service.TransactionDao;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionDao trService;
	
	@PostMapping("transaction")
	public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction tran){
		Transaction tr= trService.addTransaction(tran);
		
	return new	ResponseEntity<Transaction>(tr,HttpStatus.ACCEPTED);
			
	}

}
