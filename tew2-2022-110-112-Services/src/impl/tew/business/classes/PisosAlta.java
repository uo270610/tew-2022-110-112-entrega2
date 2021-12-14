package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.model.Piso;
import com.tew.persistence.PisoDao;
import com.tew.persistence.exception.AlreadyPersistedException;

public class PisosAlta {
	
	public void save(Piso Piso) throws AlreadyPersistedException {
		PisoDao dao = Factories.persistence.createPisoDao();
		try {
			dao.save(Piso);
		}
		catch (AlreadyPersistedException ex) {
			throw new AlreadyPersistedException("Alumno ya existe " + Piso, ex);
		}
	}
	
}
