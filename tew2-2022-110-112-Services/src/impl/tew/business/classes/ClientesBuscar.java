package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.model.Cliente;
import com.tew.persistence.ClienteDao;
import com.tew.persistence.exception.NotPersistedException;

public class ClientesBuscar {

	public Cliente find(Long id) throws NotPersistedException {
		ClienteDao dao = Factories.persistence.createClienteDao();
		Cliente c = dao.findById(id);
		if (c == null) {
			throw new NotPersistedException("No se ha encontrado el cliente");
		}
		
		return c;
	}
	
}
