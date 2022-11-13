package com.ezwallet.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezwallet.exception.BillPaymentException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.exception.LogInException;
import com.ezwallet.exception.TransactionException;
import com.ezwallet.exception.WalletException;
import com.ezwallet.service.BillPaymentService;


@RestController
public class BillPaymentController {

	@Autowired
	private BillPaymentService billPayService;
	
	@PostMapping("/addBillPayment")
	public ResponseEntity<String> addBillPayment(@RequestParam("targetMobile") String targetMobile, @RequestParam("Name") String Name, @RequestParam("amount") double amount, @RequestParam("BillType") String BillType, @RequestParam("key") String key) throws BillPaymentException, WalletException, CustomerException, LogInException, TransactionException {
		
		LocalDate date=LocalDate.now();
		String output = billPayService.addBillPayment(targetMobile, Name, amount, BillType,date , 0, key);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}
}
