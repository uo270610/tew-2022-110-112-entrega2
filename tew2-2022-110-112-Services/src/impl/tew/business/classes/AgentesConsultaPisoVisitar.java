package impl.tew.business.classes;

import java.util.List;

import com.tew.infrastructure.Factories;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.AgenteDao;

public class AgentesConsultaPisoVisitar {

	public List<PisoParaVisitar> consultaPisoVisitar(long idAgente){
		
		AgenteDao dao = Factories.persistence.createAgenteDao();
		return dao.consultaPisoVisitar(idAgente);
		
	}
	
}
