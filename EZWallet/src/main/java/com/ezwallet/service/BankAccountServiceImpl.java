package com.ezwallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezwallet.exception.BankAccountException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.model.BankAccount;
import com.ezwallet.model.BankAccountDTO;
import com.ezwallet.model.CurrentUserSession;
import com.ezwallet.model.Wallet;
import com.ezwallet.repository.BankAccountDao;
import com.ezwallet.repository.CurrentSessionDao;
import com.ezwallet.repository.CustomerRepository;
import com.ezwallet.repository.WalletRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService{
	
	@Autowired
	BankAccountDao baccDao;
	
	@Autowired
	CurrentSessionDao currentSessionDao;
	
	@Autowired
	WalletRepository walletRepository;
	
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Wallet addAccount(String key,BankAccountDTO bacc)  throws BankAccountException,CustomerException{	
        CurrentUserSession currUser=currentSessionDao.findByUuid(key);
		if(currUser==null) {
			throw new CustomerException("Please Login first");
		}
		
		
		  Optional<BankAccount> opt = baccDao.findById(bacc.getAccountNo());
			if(!opt.isEmpty()) {
				throw new BankAccountException("Bank Account already exist");
//				baccDao.save(bacc);
//				wallet= bacc.getWallet();
			} 
		
	   Wallet wall=   	walletRepository.showWalletDetails(currUser.getUserId());
	   

	   
	   BankAccount bank= new BankAccount();
	   bank.setAccountNo(bacc.getAccountNo());
	   bank.setBalance(bacc.getBalance());
	   bank.setBankName(bacc.getBankName());
	   bank.setIFSCCode(bacc.getIFSCCode());
	   bank.setWallet(wall);
	   
	   baccDao.save(bank);

		return wall;
	}
	
	
	

	@Override
	public Wallet removeAccount(String key,BankAccountDTO bacc) throws BankAccountException{
		
		
		Wallet wallet= null;
		Optional<BankAccount> opt= baccDao.findById(bacc.getAccountNo());
		
		if(opt.isPresent()) {
			baccDao.delete(opt.get());
			wallet= opt.get().getWallet();
		} else {
			 throw new BankAccountException("Bank Account does not exist");
		}
		return wallet;
	}

	@Override
	public BankAccount viewAccount(String key) throws BankAccountException,CustomerException{
		
		CurrentUserSession currUser=currentSessionDao.findByUuid(key);
		if(currUser==null) {
			throw new CustomerException("Please Login first");
		}
		
		
		BankAccount bacc= baccDao.findByWallet(walletRepository.showWalletDetails(currUser.getUserId()).getWalletId()).get(0);
		
		if(bacc==null) {
			
			throw new BankAccountException("Bank Account does not exist");
		}
		
		return bacc;
	}

	@Override
	public List<BankAccount> viewAllAccount(String key) throws BankAccountException,CustomerException{
		
		CurrentUserSession currUser=currentSessionDao.findByUuid(key);
		if(currUser==null) {
			throw new CustomerException("Please Login first");
		}
		
		
		List<BankAccount> bacc= baccDao.findAllByWallet(walletRepository.showWalletDetails(currUser.getUserId()).getWalletId());
		
		if(bacc==null) {
			
			throw new BankAccountException("Bank Account does not exist");
		}
		
		return bacc;
	}

}
