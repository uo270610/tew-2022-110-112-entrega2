package com.tew.persistence;

import com.tew.model.ReturnVerify;

public interface LoginDao {

	ReturnVerify verify(String email, String Password); 
	
}
