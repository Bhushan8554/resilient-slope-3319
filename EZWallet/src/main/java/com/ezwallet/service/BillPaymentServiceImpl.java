package com.ezwallet.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezwallet.exception.BillPaymentException;
import com.ezwallet.exception.CustomerException;
import com.ezwallet.exception.LogInException;
import com.ezwallet.exception.TransactionException;
import com.ezwallet.exception.WalletException;
import com.ezwallet.model.BillPayment;
import com.ezwallet.repository.BillPaymentDao;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{

	@Autowired
	private WalletService walletSer;
	
	@Autowired
	private BillPaymentDao billDao;
	
	@Override
	public String addBillPayment(String targetMobile, String Name,double amount,String BillType,LocalDate paymentDate,int walletId,String key) throws BillPaymentException, WalletException, CustomerException, LogInException, TransactionException {
		BigDecimal amnt = BigDecimal.valueOf(amount);
		String str = walletSer.fundTransferToAnotherMobileNumber(targetMobile, Name, amnt, key);
		
		BillPayment newbill = new BillPayment();
		newbill.setAmount(amount);
		newbill.setBillType(BillType);
		newbill.setPaymentDate(LocalDate.now());
		billDao.save(newbill);
		
        return str;
	
	}

}
