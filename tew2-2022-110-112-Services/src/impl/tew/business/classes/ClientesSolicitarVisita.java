package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.model.Piso;
import com.tew.persistence.ClienteDao;
import com.tew.persistence.exception.NotPersistedException;

public class ClientesSolicitarVisita {

	public void solicitarVisita(long idPiso, long idCliente) throws NotPersistedException {
		ClienteDao dao = Factories.persistence.createClienteDao();
		dao.solicitarVisita(idPiso, idCliente);
	}
	
}
