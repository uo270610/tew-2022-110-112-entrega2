package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.model.Piso;
import com.tew.persistence.PisoDao;
import com.tew.persistence.exception.NotPersistedException;

public class PisosUpdate {

	public void update(Piso Piso) throws NotPersistedException {
		PisoDao dao = Factories.persistence.createPisoDao();
		try {
			dao.update(Piso);
		}
		catch (NotPersistedException ex) {
			throw new NotPersistedException("Piso no eliminado " + Piso, ex);
		}
	}
	
}
