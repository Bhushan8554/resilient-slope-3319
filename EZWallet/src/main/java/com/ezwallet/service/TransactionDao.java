package com.ezwallet.service;

import com.ezwallet.exception.TransactionException;
import com.ezwallet.model.Transaction;

public interface TransactionDao {
	
	public Transaction addTransaction(Transaction tran);
	

}
