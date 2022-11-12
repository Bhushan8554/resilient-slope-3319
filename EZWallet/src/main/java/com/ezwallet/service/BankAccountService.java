package com.ezwallet.service;


import java.util.List;

import com.ezwallet.exception.BankAccountException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.model.BankAccount;
import com.ezwallet.model.BankAccountDTO;
import com.ezwallet.model.Wallet;

public interface BankAccountService {
	
	public Wallet addAccount(String key,BankAccountDTO bacc) throws BankAccountException,CustomerException;
	
	public Wallet removeAccount(BankAccount bacc) throws BankAccountException;
	
	public BankAccount viewAccount(String key,Wallet wallet) throws BankAccountException, CustomerException;
	
	public List<BankAccount> viewAllAccount(String key,Wallet wallet) throws BankAccountException, CustomerException;

}
