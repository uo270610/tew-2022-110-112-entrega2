package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.model.Cliente;
import com.tew.persistence.ClienteDao;
import com.tew.persistence.exception.AlreadyPersistedException;

public class ClientesAlta {

	public void save(Cliente cliente) throws AlreadyPersistedException {
		ClienteDao dao = Factories.persistence.createClienteDao();
		try {
			dao.save(cliente);
		}
		catch (AlreadyPersistedException ex) {
			throw new AlreadyPersistedException("Alumno ya existe " + cliente, ex);
		}
	}
	
}
