package impl.tew.business.classes;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.infrastructure.Factories;
import com.tew.model.Piso;
import com.tew.persistence.PisoDao;
import com.tew.persistence.exception.NotPersistedException;

public class PisosUpdate {

	public void update(Piso Piso) throws EntityNotFoundException {
		PisoDao dao = Factories.persistence.createPisoDao();
		try {
			dao.update(Piso);
		}
		catch (NotPersistedException ex) {
			throw new EntityNotFoundException("Piso no eliminado " + Piso, ex);
		}
	}
	
}
