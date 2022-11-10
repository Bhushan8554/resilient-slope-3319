package com.ezwallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ezwallet.model.Beneficiary;

@Repository
public interface BeneficiaryDao extends JpaRepository<Beneficiary, String>{
	
	public List<Beneficiary> findByName(String name);
	
}
