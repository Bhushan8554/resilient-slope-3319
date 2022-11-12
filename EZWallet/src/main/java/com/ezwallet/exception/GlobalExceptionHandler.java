package com.ezwallet.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.support.BeanDefinitionValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BankAccountException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(BankAccountException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(BeneficiaryException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(BeneficiaryException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(BillPaymentException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(BillPaymentException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(CustomerException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(LogInException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(LogInException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(TransactionException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(TransactionException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(BeanDefinitionValidationException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(BeanDefinitionValidationException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(IllegalArgumentException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(WalletException.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(WalletException ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> ezwalletExceptionHandler(Exception ee,WebRequest req){
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
		
	}
}
