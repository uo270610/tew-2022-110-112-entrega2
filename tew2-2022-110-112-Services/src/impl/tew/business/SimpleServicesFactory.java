package impl.tew.business;


import com.tew.business.AgenteService;
import com.tew.business.ClienteService;
import com.tew.business.LoginService;
import com.tew.business.PisoParaVisitarService;
import com.tew.business.PisoService;
import com.tew.business.ServicesFactory;

public class SimpleServicesFactory implements ServicesFactory {

	@Override
	public LoginService createLoginService() {
		// TODO Auto-generated method stub
		return new SimpleLoginService();
	}

	@Override
	public ClienteService createClienteService() {
		// TODO Auto-generated method stub
		return new SimpleClienteService();
	}

	@Override
	public AgenteService createAgenteService() {
		// TODO Auto-generated method stub
		return new SimpleAgenteService();
	}
	
	@Override
	public PisoService createPisoService() {
		return null;
	}
	
	@Override
	public PisoParaVisitarService createPisoParaVisitarService() {
		return null;
	}

}
