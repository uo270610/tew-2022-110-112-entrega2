package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.persistence.AgenteDao;

public class AgentesResetDB {

	public void resetDB() throws Exception {
		
		AgenteDao dao = Factories.persistence.createAgenteDao();
		dao.resetDB();
		
	}
	
}
