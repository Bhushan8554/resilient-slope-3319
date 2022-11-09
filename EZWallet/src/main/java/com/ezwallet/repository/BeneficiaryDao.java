package com.ezwallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezwallet.model.Beneficiary;

public interface BeneficiaryDao extends JpaRepository<Beneficiary, String>{

}
