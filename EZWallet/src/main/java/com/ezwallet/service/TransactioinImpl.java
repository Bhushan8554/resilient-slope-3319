package com.ezwallet.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezwallet.exception.TransactionException;
import com.ezwallet.exception.WalletException;
import com.ezwallet.model.Transaction;
import com.ezwallet.model.Wallet;
import com.ezwallet.repository.TransactionRepo;
import com.ezwallet.repository.WalletRepository;


@Service
public abstract class TransactioinImpl implements TransactionDao{
	
	@Autowired
	private TransactionRepo tRepo;
	
	@Autowired
	private WalletRepository walletRepository;

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
	
	@Override
	public Transaction viewAllTransaction(Wallet wallet) throws TransactionException,WalletException {
		
		Optional<Wallet>  wal=  walletRepository.findById(wallet.getWalletId());
		
		if(!wal.isPresent()) {
			throw new WalletException("Wallet Id invalid.");
		}
		
		Transaction tar=tRepo.findByWallet(wallet);
		
		if(tar==null)throw new TransactionException("Transaction not found.");
	
		return tar;
		
	}



}
