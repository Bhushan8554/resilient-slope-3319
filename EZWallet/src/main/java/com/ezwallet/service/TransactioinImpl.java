package com.ezwallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezwallet.exception.TransactionException;
import com.ezwallet.model.Transaction;
import com.ezwallet.repository.TransactionRepo;


@Service
public class TransactioinImpl implements TransactionDao{
	
	@Autowired
	private TransactionRepo tRepo;

	@Override
	public Transaction addTransaction(Transaction tran){
		// TODO Auto-generated method stub
		return null;
	}

}
