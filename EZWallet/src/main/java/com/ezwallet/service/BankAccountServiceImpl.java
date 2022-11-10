package com.ezwallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezwallet.exception.BankAccountException;
import com.ezwallet.model.BankAccount;
import com.ezwallet.model.Wallet;
import com.ezwallet.repository.BankAccountDao;

public class BankAccountServiceImpl implements BankAccountService{
	
	@Autowired
	BankAccountDao baccDao;
	
	

	@Override
	public Wallet addAccount(BankAccount bacc)  throws BankAccountException{
		Wallet wallet= null;
		Optional<BankAccount> opt = baccDao.findById(bacc.getAccountNo());
				
				if(opt.isEmpty()) {
					baccDao.save(bacc);
					wallet= bacc.getWallet();
				} else {
					throw new BankAccountException("Bank Account already exist");
				}
		return wallet;
	}

	@Override
	public Wallet removeAccount(BankAccount bacc) throws BankAccountException{
		Wallet wallet= null;
		Optional<BankAccount> opt= baccDao.findById(bacc.getAccountNo());
		
		if(opt.isPresent()) {
			baccDao.delete(bacc);
			wallet= opt.get().getWallet();
		} else {
			 throw new BankAccountException("Bank Account does not exist");
		}
		return wallet;
	}

	@Override
	public BankAccount viewAccount(Wallet wallet) throws BankAccountException{
		
		BankAccount bacc= baccDao.findByWallet(wallet);
		
		if(bacc==null) {
			
			throw new BankAccountException("Bank Account does not exist");
		}
		
		return bacc;
	}

	@Override
	public List<BankAccount> viewAllAccount(Wallet wallet) throws BankAccountException{
		
		
		
		List<BankAccount> baccList= baccDao.findAllByWallet(wallet);
		
		
		if(baccList.isEmpty()) {
			throw new BankAccountException("Bank Accounts do not exist");
		}
		
		return baccList;
	}

}
