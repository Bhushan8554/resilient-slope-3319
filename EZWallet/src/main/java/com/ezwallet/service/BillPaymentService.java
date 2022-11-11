package com.ezwallet.service;

import java.util.List;

import com.ezwallet.exception.BillPaymentException;
import com.ezwallet.model.BillPayment;

public interface BillPaymentService {

	public String addBillPayment(BillPayment bill) throws BillPaymentException;
	
	public List<BillPayment> viewBillPayment() throws BillPaymentException;

}
