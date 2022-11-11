package com.ezwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezwallet.model.BillPayment;

@Repository
public interface BillPaymentDao extends JpaRepository<BillPayment, Integer> {

}
