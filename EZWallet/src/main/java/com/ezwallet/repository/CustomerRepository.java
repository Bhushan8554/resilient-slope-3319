package com.ezwallet.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ezwallet.model.Customer;
import com.ezwallet.model.Wallet;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("from Customer c where c.mobileNumber=?1")
	public List<Customer> findCustomerByMobile(String mobileNumber);
	
	
	@Query("select w.balance from Customer c, Wallet w where c.customerId=?1")
	public BigDecimal showWalletBalance(Integer id);
}