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

import com.ezwallet.exception.BeneficiaryException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.model.Beneficiary;
import com.ezwallet.model.Wallet;
import com.ezwallet.service.BeneficiaryService;

@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {

	@Autowired
	BeneficiaryService beneficiaryService;
	
	
//	@PostMapping("/beneficiaries")
//	public ResponseEntity<Beneficiary> addBeneneficiaryMapping(@RequestBody Beneficiary beneficiary) throws BeneficiaryException{
//		
//		return new ResponseEntity<Beneficiary>(beneficiaryService.addBeneficiary(beneficiary),HttpStatus.ACCEPTED);
//		
//		
//	}
//	
	
	@DeleteMapping("/beneficiaries")
	public ResponseEntity<Beneficiary> deleteBeneneficiaryMapping(@Valid@RequestBody Beneficiary beneficiary) throws BeneficiaryException{
		
		return new ResponseEntity<Beneficiary>(beneficiaryService.deleteBeneficiary(beneficiary),HttpStatus.OK);
		
		
	}
	
//	@GetMapping("/beneficiaries")
//	public ResponseEntity<List<Beneficiary>> getAllBeneneficiaryMapping(@RequestBody Beneficiary beneficiary) throws BeneficiaryException{
//		
//		return new ResponseEntity<List<Beneficiary>>(beneficiaryService.viewAllBeneficiary(beneficiary),HttpStatus.FOUND);
//		
//		
//	}
	
	
	@PostMapping("/beneficiariesbywallet")
	public ResponseEntity<List<Beneficiary>> getAllBeneneficiaryByWalletMapping(@Valid@RequestBody Wallet wallet) throws BeneficiaryException{
		
		return new ResponseEntity<List<Beneficiary>>(beneficiaryService.findAllByWallet(wallet),HttpStatus.FOUND);
		
		
	}
	
	@GetMapping("/beneficiaries")
	public ResponseEntity<List<Beneficiary>> getBeneneficiaryMapping(@RequestParam String name,@RequestParam String key) throws BeneficiaryException, CustomerException{
		
		return new ResponseEntity<List<Beneficiary>>(beneficiaryService.viewBeneficiary(name,key),HttpStatus.FOUND);
		
		
	}
}
