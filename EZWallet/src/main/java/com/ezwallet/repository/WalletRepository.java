package com.ezwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezwallet.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

	
}
