package impl.tew.business;

import java.util.List;

import com.tew.business.AgenteService;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Agente;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.exception.NotPersistedException;

import impl.tew.business.classes.AgentesBuscar;
import impl.tew.business.classes.AgentesCitarVisita;
import impl.tew.business.classes.AgentesConsultaPisoVisitar;
import impl.tew.business.classes.AgentesListado;
import impl.tew.business.classes.AgentesResetDB;

public class SimpleAgenteService implements AgenteService {

	@Override
	public List<Agente> getAgentes() throws Exception {
		// TODO Auto-generated method stub
		return new AgentesListado().getAgente();
	}

	@Override
	public Agente findById(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return new AgentesBuscar().findById(id);
	}

	@Override
	public List<PisoParaVisitar> consultaPisoVisitar(long idAgente) throws Exception {
		// TODO Auto-generated method stub
		return new AgentesConsultaPisoVisitar().consultaPisoVisitar(idAgente);
	}

	@Override
	public void citarVisita(long idPiso, long idCliente) throws NotPersistedException {
		// TODO Auto-generated method stub
		new AgentesCitarVisita().citarVisita(idPiso, idCliente);
	}

	@Override
	public void resetDB() throws Exception {
		// TODO Auto-generated method stub
		new AgentesResetDB().resetDB();
	}

}
