package com.ezwallet.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ezwallet.model.Transaction;


@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
	
	
	@Query(value =  "from Transaction WHERE transactionDate BETWEEN ?1 AND ?2")
	public List<Transaction> viewAllTransactionByDate(LocalDate from, LocalDate to);
	
	public List<Transaction> findByTransactionType(String transactionType);
	
	@Query(value = "from Transaction t INNER JOIN t.wallet w where w.walletId=?1")
	public List<Transaction> findByWallet(Integer walletId);
	
	public List<Transaction> findByTransactionDate(LocalDate date);

}
