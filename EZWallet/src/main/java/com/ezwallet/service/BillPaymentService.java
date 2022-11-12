package com.ezwallet.service;

import java.time.LocalDate;
import java.util.List;

import com.ezwallet.exception.BillPaymentException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.exception.LogInException;
import com.ezwallet.exception.TransactionException;
import com.ezwallet.exception.WalletException;
import com.ezwallet.model.BillPayment;

public interface BillPaymentService {

	public String addBillPayment(String targetMobile, String Name,double amount,String BillType,LocalDate paymentDate,int walletId,String key) throws BillPaymentException,WalletException,CustomerException,LogInException,TransactionException;


}
