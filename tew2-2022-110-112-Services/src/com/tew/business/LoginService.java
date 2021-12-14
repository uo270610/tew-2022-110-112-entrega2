package com.tew.business;

import com.tew.model.ReturnVerify;
import com.tew.persistence.exception.NotPersistedException;

public interface LoginService {
	
	public ReturnVerify verify(String name, String password) throws NotPersistedException;
	
	
}