package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.persistence.ClienteDao;
import com.tew.persistence.exception.NotPersistedException;

public class ClientesBaja {

	public void delete(Long id) throws NotPersistedException {
		ClienteDao dao = Factories.persistence.createClienteDao();
		try {
			dao.delete(id);
		}
		catch (NotPersistedException ex) {
			throw new NotPersistedException("Cliente no eliminado " + id, ex);
		}
	}
	
}
