package impl.tew.business.classes;

import java.util.List;

import com.tew.infrastructure.Factories;
import com.tew.model.Cliente;
import com.tew.persistence.ClienteDao;

public class ClientesListado {

	public List<Cliente> getCliente() throws Exception {
	
		ClienteDao dao = Factories.persistence.createClienteDao();
		return  dao.getClientes();
	
	}
	
}
