package impl.tew.business.classes;

import java.util.List;

import com.tew.infrastructure.Factories;
import com.tew.model.Agente;
import com.tew.persistence.AgenteDao;

public class AgentesListado {

	public List<Agente> getAgente() throws Exception {
		
		AgenteDao dao = Factories.persistence.createAgenteDao();
		return  dao.getAgentes();
		
	}
	
}
