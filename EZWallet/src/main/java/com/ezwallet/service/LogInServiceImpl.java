package com.ezwallet.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezwallet.exception.LogInException;
import com.ezwallet.model.CurrentUserSession;
import com.ezwallet.model.Customer;
import com.ezwallet.model.LogInDTO;
import com.ezwallet.repository.CurrentSessionDao;
import com.ezwallet.repository.CustomerRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LogInServiceImpl implements LogInService{

	@Autowired
	private CustomerRepository cDao;
	
	@Autowired
	private CurrentSessionDao sDao;

	@Override
	public String logInService(LogInDTO logdto) throws LogInException {
		
         
		List<Customer> customer= cDao.findCustomerByMobile(logdto.getMobileNumber());
		
		Customer existingCustomer = customer.get(0);
		
		if(existingCustomer == null) {
			throw new LogInException("Wrong input!! Please Enter a valid mobile number...");
		}
		
		Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findByUserId(existingCustomer.getCustomerId());
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LogInException("Already Logged In...");
			
		}
		
		if(existingCustomer.getPassword().equals(logdto.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			sDao.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LogInException("Please Enter a valid password");
		
		
	}

	@Override
	public String logOutService(String key) throws LogInException {

		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		
		if(validCustomerSession == null) {
			throw new LogInException("Wrong Unique User Id !! Try again..");
			
		}
		
		sDao.delete(validCustomerSession);
		
		return "You are Logged Out !";
	}

}
