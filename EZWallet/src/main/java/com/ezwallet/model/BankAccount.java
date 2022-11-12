package com.ezwallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankAccount {

	@Id
	@NotNull
	private Integer accountNo;
	
	@NotNull
	@Size(min = 4, max = 10,message = "IFSC not valid")
	private String IFSCCode;
	
	@NotNull
	@Size(min = 4, max = 10,message = "IFSC not valid")
	private String bankName;
	
	@NotNull
	private Double balance;
	
	
	@ManyToOne(cascade= CascadeType.ALL)
//	@JoinColumn(name = "wid",referencedColumnName = "walletId")
	private Wallet wallet;
	
	


	public Integer getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}


	public String getIFSCCode() {
		return IFSCCode;
	}


	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public Wallet getWallet() {
		return wallet;
	}


	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	

}
