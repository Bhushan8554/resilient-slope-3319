package com.ezwallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezwallet.model.BankAccount;
import com.ezwallet.model.Wallet;

public interface BankAccountDao  extends JpaRepository<BankAccount, Integer>{
	
	public BankAccount findByWallet(Wallet wallet);
	
	public List<BankAccount> findAllByWallet(Wallet wallet);

}
