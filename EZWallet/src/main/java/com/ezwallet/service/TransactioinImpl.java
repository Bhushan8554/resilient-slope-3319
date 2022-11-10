package com.ezwallet.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezwallet.exception.TransactionException;
import com.ezwallet.model.Beneficiary;
import com.ezwallet.model.Customer;
import com.ezwallet.model.Transaction;
import com.ezwallet.model.Wallet;
import com.ezwallet.repository.TransactionRepo;


@Service
public abstract class TransactioinImpl implements TransactionDao{
	
	@Autowired
	private TransactionRepo tRepo;

	@Override
	public Transaction addTransaction(Transaction tran) throws TransactionException {
		
		if(tRepo.save(tran) != null) {
	     	return tran;
			
		}else {
			throw new TransactionException("Data is null");
		}
	}

	@Override
	public List<Transaction> viewTransactionByDate(LocalDate from, LocalDate to) throws TransactionException {

		List<Transaction> dateList= tRepo.viewAllTransactionByDate(from, to);
		
		if(dateList.size()==0)throw new TransactionException("No any Transaction Between this Date.");
		return dateList;
	}

	@Override
	public List<Transaction> viewAllTransactionByType(String type) throws TransactionException {
		
		List<Transaction> allList= tRepo.findBytransactionType(type);
		
		if(allList.size()==0)throw new TransactionException("List is empty..");
		return allList;
	}



}
