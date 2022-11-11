package com.ezwallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ezwallet.model.Transaction;
import com.ezwallet.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
	
	@Query("from Transaction t, Wallet e  where t")
	public List<Transaction> viewAllTransactionsByWallet(Wallet wallet);

}
