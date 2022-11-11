package com.ezwallet.service;

import java.time.LocalDate;
import java.util.List;

import com.ezwallet.exception.TransactionException;
import com.ezwallet.exception.WalletException;
import com.ezwallet.model.Transaction;
import com.ezwallet.model.Wallet;

public interface TransactionDao {
	
	public Transaction addTransaction(Transaction tran) throws TransactionException;
	public Transaction viewAllTransaction(Wallet wallet)throws TransactionException,WalletException;
	public List<Transaction> viewTransactionByDate(LocalDate from, LocalDate to) throws TransactionException;
	public List<Transaction> viewAllTransactionByType(String type) throws TransactionException;

}
