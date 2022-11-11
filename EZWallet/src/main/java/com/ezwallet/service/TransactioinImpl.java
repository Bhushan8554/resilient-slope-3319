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
public class TransactioinImpl implements TransactionService{
	
	@Autowired
	private TransactionRepo transactionRepository;
	
	@Autowired
	private WalletRepository walletRepository;
	
	

	@Override
	public Transaction addTransaction(Transaction tran) throws TransactionException, WalletException {	
		Optional<Wallet> wallet=	walletRepository.findById(tran.getWallet().getWalletId());
		if(!wallet.isPresent())throw new WalletException("Wallet id worng.");
		if(transactionRepository.save(tran) != null)return tran;
	     	throw new TransactionException("Data is null");
	}
	
	
	

	@Override
	public List<Transaction> viewTransactionByDate(LocalDate from, LocalDate to) throws TransactionException {
		List<Transaction> dateList= transactionRepository.viewAllTransactionByDate(from, to);
		if(dateList.size()==0)throw new TransactionException("No any Transaction Between this Date.");
		return dateList;
	}
	
	
	
	
//	@Override
//	public Transaction viewAllTransaction(Wallet wallet)throws TransactionException,WalletException{
//		
//	Optional<Wallet> findWallet=	walletRepository.findById(wallet.getWalletId());
//		if(!findWallet.isPresent())throw new WalletException("Wallet Id invalid.");
//		
//		return null;
//		
//	}
	
	@Override
	public Transaction findByTransactionId(Integer id)throws TransactionException{
		Optional<Transaction> transaction = transactionRepository.findById(id);
		
		if(!transaction.isPresent())throw new TransactionException("Invalid Id.");
		return transaction.get();
		
	}
	
	@Override
	public List<Transaction> findByTransactionType(String transactionType) throws TransactionException{
		List<Transaction> listOTransactions = transactionRepository.findByTransactionType(transactionType);
		if(listOTransactions.size()==0)throw new TransactionException("Transaction list Empty..");
		return listOTransactions;
	}



}
