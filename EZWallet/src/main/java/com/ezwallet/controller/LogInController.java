package com.ezwallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezwallet.exception.LogInException;
import com.ezwallet.model.LogInDTO;
import com.ezwallet.service.LogInService;

@RestController
public class LogInController {

	@Autowired
	private LogInService logService;
	
	@PostMapping("/logIn")
	public ResponseEntity<String> logInService(@RequestBody LogInDTO logdto) throws LogInException{
		
		String output = logService.logInService(logdto);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}
	
	@PostMapping("/logOut")
	public ResponseEntity<String> logOutService(@RequestParam String key) throws LogInException{
		
		String output = logService.logOutService(key);
		
		return new ResponseEntity<String>(output,HttpStatus.OK);
	}
}
