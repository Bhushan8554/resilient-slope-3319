package com.ezwallet.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ezwallet.model.BankAccount;

@Repository

public interface BankAccountDao  extends JpaRepository<BankAccount, Integer>{
	
	@Query(value = "from BankAccount b INNER JOIN b.wallet w where w.walletId=?1")
	public List<BankAccount>  findByWallet(Integer walletId);
	@Query(value = "from BankAccount b INNER JOIN b.wallet w where w.walletId=?1")
	public List<BankAccount> findAllByWallet(Integer walletId);

}
