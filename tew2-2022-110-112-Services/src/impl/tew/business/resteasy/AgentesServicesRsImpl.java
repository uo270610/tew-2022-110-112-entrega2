package impl.tew.business.resteasy;

import java.util.List;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.business.resteasy.AgentesServicesRs;
import com.tew.model.Agente;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

import impl.tew.business.SimpleAgenteService;
import impl.tew.business.classes.AgentesCitarVisita;


public class AgentesServicesRsImpl implements AgentesServicesRs{
	
	@Override
	public List<Agente> getAgentes() {
		// TODO Auto-generated method stub
		try {
			return new SimpleAgenteService().getAgentes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Listado de Agentes IMPL");
			return null;
		}
	}

	@Override
	public Agente findById(Long a) throws EntityNotFoundException {
		return new SimpleAgenteService().findById(a);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PisoParaVisitar> consultaPisoVisitar(long idAgente) throws Exception{
		// TODO Auto-generated method stub
		return new SimpleAgenteService().consultaPisoVisitar(idAgente);
	}

	@Override
	public void citarVisita(long idPiso, long idCliente) throws NotPersistedException{
		new SimpleAgenteService().citarVisita(idPiso,idCliente);
	}

	@Override
	public void resetDB() throws Exception {
		// TODO Auto-generated method stub
		new SimpleAgenteService().resetDB();
	}
}
