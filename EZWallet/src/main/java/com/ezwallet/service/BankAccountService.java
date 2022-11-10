package com.ezwallet.service;


import java.util.List;

import com.ezwallet.exception.BankAccountException;
import com.ezwallet.model.BankAccount;
import com.ezwallet.model.Wallet;

public interface BankAccountService {
	
	public Wallet addAccount(BankAccount bacc) throws BankAccountException;
	
	public Wallet removeAccount(BankAccount bacc) throws BankAccountException;
	
	public BankAccount viewAccount(Wallet wallet) throws BankAccountException;
	
	public List<BankAccount> viewAllAccount(Wallet wallet) throws BankAccountException;

}
