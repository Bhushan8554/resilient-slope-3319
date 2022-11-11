package com.ezwallet.service;

import com.ezwallet.exception.LogInException;
import com.ezwallet.model.LogInDTO;

public interface LogInService {

    public String logInService (LogInDTO logdto) throws LogInException;
	
	public String logOutService (String Key) throws LogInException;
}
