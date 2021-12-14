package impl.tew.business;

import com.tew.business.LoginService;
import com.tew.model.ReturnVerify;
import com.tew.persistence.exception.NotPersistedException;

import impl.tew.business.classes.Login;

public class SimpleLoginService implements LoginService{

	@Override
	public ReturnVerify verify(String name, String password) throws NotPersistedException {
		// TODO Auto-generated method stub
		return new Login().verify(name, password);
	}	
	
}
