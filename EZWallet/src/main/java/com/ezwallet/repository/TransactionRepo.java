package com.ezwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezwallet.model.Transaction;


@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

}
