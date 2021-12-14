package impl.tew.business.classes;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.infrastructure.Factories;
import com.tew.model.Agente;
import com.tew.persistence.AgenteDao;

public class AgentesBuscar {

	public Agente findById(Long id) throws EntityNotFoundException {
		
		AgenteDao dao = Factories.persistence.createAgenteDao();
		return  dao.findById(id);
		
	}
	
}
