package com.ezwallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezwallet.exception.BeneficiaryException;
import com.ezwallet.model.Beneficiary;
import com.ezwallet.model.Wallet;
import com.ezwallet.repository.BeneficiaryDao;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {
	
	@Autowired
	BeneficiaryDao beneficiaryDao;

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
	public List<Beneficiary> viewBeneficiary(String name) throws BeneficiaryException {
		List<Beneficiary> beneficiaries=beneficiaryDao.findByName(name);
		
		
		if(beneficiaries.isEmpty()) {
			throw new BeneficiaryException("Beneficiary Not Exist");
			
		}else {
			return beneficiaries;
		}
	}

	public List<Beneficiary> viewAllBeneficiary(Beneficiary beneficiary) throws BeneficiaryException{
		
		Optional<Beneficiary> optional=beneficiaryDao.findById(beneficiary.getMobileNumber());
		
		if(optional.isPresent()) {
			List<Beneficiary> beneficiaries=findAllByWallet(optional.get().getWallet());
			if(beneficiaries.isEmpty()) {
				throw new BeneficiaryException("Beneficiary not found");
			}else {
				return beneficiaries;
			}
		}
		else {
			throw new BeneficiaryException("Beneficiary not Exist");
		}
	}

	public List<Beneficiary> findAllByWallet(Wallet wallet) throws BeneficiaryException {
		
		List<Beneficiary> beneficiaries=beneficiaryDao.findByWallet(wallet);
		if(beneficiaries.isEmpty()) {
			throw new BeneficiaryException("Beneficiary not found");
		}else {
			return beneficiaries;
		}
		
		
	}

}
