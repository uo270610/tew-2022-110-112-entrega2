package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.persistence.ClienteDao;
import com.tew.persistence.exception.NotPersistedException;

public class ClientesConfirmarVisita {

	public void confirmarVisita(long idPiso, long idCliente) throws NotPersistedException {
		ClienteDao dao = Factories.persistence.createClienteDao();
		dao.confirmarVisita(idPiso, idCliente);
	}
	
}
