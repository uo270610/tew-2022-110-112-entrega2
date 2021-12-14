package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.model.Piso;
import com.tew.persistence.PisoDao;
import com.tew.persistence.exception.NotPersistedException;

public class PisosBuscar {

	public Piso find(Long id) throws NotPersistedException {
		PisoDao dao = Factories.persistence.createPisoDao();
		Piso p = dao.findById(id);
		if (p == null) {
			throw new NotPersistedException("No se ha encontrado el piso");
		}
		
		return p;
	}
	
}
