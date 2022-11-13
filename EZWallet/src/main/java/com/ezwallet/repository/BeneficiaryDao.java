package com.ezwallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ezwallet.model.Beneficiary;
import com.ezwallet.model.Wallet;

@Repository
public interface BeneficiaryDao extends JpaRepository<Beneficiary, String>{
	
	@Query(value = "from Beneficiary b INNER JOIN b.wallet w where w.walletId=?1 AND b.name =?2")
	public Beneficiary findByNameWallet(Integer walletId,String name);
	
	@Query(value = "from Beneficiary b INNER JOIN b.wallet w where w.walletId=?1 AND b.mobileNumber =?2")
	public Beneficiary findByMobWallet(Integer walletId,String name);
	
	@Query(value = "from Beneficiary b INNER JOIN b.wallet w where w.walletId=?1")
	public List<Beneficiary> findByWallet(Integer walletId);
	
	
}
