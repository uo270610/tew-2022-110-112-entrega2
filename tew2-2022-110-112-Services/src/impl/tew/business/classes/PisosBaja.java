package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.persistence.PisoDao;
import com.tew.persistence.exception.NotPersistedException;

public class PisosBaja {

	public void delete(Long id) throws NotPersistedException {
		PisoDao dao = Factories.persistence.createPisoDao();
		try {
			dao.delete(id);
		}
		catch (NotPersistedException ex) {
			throw new NotPersistedException("Piso no eliminado " + id, ex);
		}
	}
	
}
