package com.ezwallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezwallet.exception.BeneficiaryException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.model.Beneficiary;
import com.ezwallet.model.CurrentUserSession;
import com.ezwallet.model.Customer;
import com.ezwallet.model.Wallet;
import com.ezwallet.repository.BeneficiaryDao;
import com.ezwallet.repository.CurrentSessionDao;
import com.ezwallet.repository.CustomerRepository;
import com.ezwallet.repository.WalletRepository;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {
	
	@Autowired
	BeneficiaryDao beneficiaryDao;

	@Autowired
	CurrentSessionDao currentSessionDao;
	
	@Autowired
	WalletRepository walletRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Beneficiary addBeneficiary(Beneficiary beneficiary) throws BeneficiaryException {
		Optional<Beneficiary> optional=beneficiaryDao.findById(beneficiary.getMobileNumber());
		
		if(optional.isEmpty()) {
			return beneficiaryDao.save(beneficiary);
		}
		else {
			throw new BeneficiaryException("Beneficiary Allready Exist");
		}
	}
	

	@Override
	public Beneficiary deleteBeneficiary(Beneficiary beneficiary) throws BeneficiaryException {
		
		List<Beneficiary> beneficiaries=beneficiaryDao.findByNameWallet(beneficiary.getWallet().getWalletId(),beneficiary.getName());
		
		if(!beneficiaries.contains(beneficiary)) {
			throw new BeneficiaryException("No such beneficiary Exist");
		}
		// TODO Auto-generated method stub
		Optional<Beneficiary> optional=beneficiaryDao.findById(beneficiary.getMobileNumber());
		
		if(optional.isPresent()) {
			beneficiaryDao.delete(beneficiary);
			return optional.get();
		}
		else {
			throw new BeneficiaryException("Beneficiary Not Exist");
		}
	}

	@Override
	public List<Beneficiary> viewBeneficiary(String name,String key) throws BeneficiaryException, CustomerException {
		
		CurrentUserSession currUser=currentSessionDao.findByUuid(key);
		
		
		if(currUser==null) {
			throw new CustomerException("Please Login first");
		}
		
		Wallet wallet=walletRepository.showWalletDetails(currUser.getUserId());
		List<Beneficiary> beneficiaries=beneficiaryDao.findByNameWallet(wallet.getWalletId(),name);
		
		
		if(beneficiaries.isEmpty()) {
			throw new BeneficiaryException("Beneficiary Not Exist");
			
		}else {
			return beneficiaries;
		}
	}

//	public List<Beneficiary> viewAllBeneficiary(Beneficiary beneficiary) throws BeneficiaryException{
//		
//		Optional<Beneficiary> optional=beneficiaryDao.findById(beneficiary.getMobileNumber());
//		
//		if(optional.isPresent()) {
//			List<Beneficiary> beneficiaries=findAllByWallet(optional.get().getWallet());
//			if(beneficiaries.isEmpty()) {
//				throw new BeneficiaryException("Beneficiary not found");
//			}else {
//				return beneficiaries;
//			}
//		}
//		else {
//			throw new BeneficiaryException("Beneficiary not Exist");
//		}
//	}

	public List<Beneficiary> findAllByWallet(Wallet wallet) throws BeneficiaryException {
		
		
		List<Beneficiary> beneficiaries=beneficiaryDao.findByWallet(wallet.getWalletId());
		if(beneficiaries.isEmpty()) {
			throw new BeneficiaryException("Beneficiary not found");
		}else {
			return beneficiaries;
		}
		
		
	}

}
