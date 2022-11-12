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
	public List<Transaction> viewTransactionByDate(LocalDate date, LocalDate two)throws TransactionException {
		LocalDate currentDate=LocalDate.now();
		if(date.isAfter(currentDate))throw new TransactionException("First Date is future.");
		if(two.isAfter(currentDate))throw new TransactionException("Second Date is future.");
		if(date.isAfter(two)) throw new TransactionException("Frist date is invalid.");
		List<Transaction> listOfTransactions= transactionRepository.findByDateBetween(date, two);
		return listOfTransactions;
	}
	
	
	
	
	@Override
	public List<Transaction> findByWallet(Wallet wallet) throws TransactionException, WalletException {
		Optional<Wallet> wall= walletRepository.findById(wallet.getWalletId());
		System.out.println(wall);
		if(!wall.isPresent())throw new WalletException("Wallet id Invalid.");
		List<Transaction> listTransactions= transactionRepository.findByWallet(wallet.getWalletId());
		if(listTransactions.size()==0)throw new TransactionException("List is empty");
		return listTransactions;
	}
	
	
	
	
	
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




	@Override
	public List<Transaction> viewAllTransaction() throws TransactionException {
		List<Transaction> listTransactions= transactionRepository.findAll();
		if(listTransactions.size()==0)throw new TransactionException("No any type transaction.");
		return listTransactions;
	}




	@Override
	public List<Transaction> findByDate(LocalDate date) throws TransactionException {
		LocalDate currentDate=LocalDate.now();
		if(date.isAfter(currentDate))throw new TransactionException("Date is future");
		List<Transaction> listOfTransactions= transactionRepository.findByTransactionDate(date);
		if(listOfTransactions.size()==0)throw new TransactionException("List is Empty.");
		return listOfTransactions;
	}



}
