package com.ezwallet.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<String> addBillPayment(@PathVariable("targetMobile") String targetMobile, @PathVariable("Name") String Name, @PathVariable("amount") double amount, @PathVariable("BillType") String BillType, @PathVariable("paymentDate") LocalDate paymentDate, @PathVariable("walletId") int walletId, @PathVariable("key") String key) throws BillPaymentException, WalletException, CustomerException, LogInException, TransactionException {
		
		String output = billPayService.addBillPayment(targetMobile, Name, amount, BillType, paymentDate, walletId, key);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}
}
