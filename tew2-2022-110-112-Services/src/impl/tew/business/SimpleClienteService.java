package impl.tew.business;

import java.util.List;

import com.tew.business.ClienteService;
import com.tew.model.Cliente;
import com.tew.model.Piso;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

import impl.tew.business.classes.ClientesAlta;
import impl.tew.business.classes.ClientesBaja;
import impl.tew.business.classes.ClientesBuscar;
import impl.tew.business.classes.ClientesConfirmarVisita;
import impl.tew.business.classes.ClientesConsultaPisoVisitar;
import impl.tew.business.classes.ClientesConsultaPorCiudad;
import impl.tew.business.classes.ClientesConsultaPorPrecio;
import impl.tew.business.classes.ClientesListado;
import impl.tew.business.classes.ClientesSolicitarVisita;

public class SimpleClienteService implements ClienteService {
	
	@Override
	public List<Cliente> getClientes() throws Exception{		
		return new ClientesListado().getCliente();		
	}
	@Override
	public void saveCliente(Cliente cliente) throws AlreadyPersistedException {		
		new ClientesAlta().save(cliente);		
	}
	@Override
	public void updateCliente(long id) throws NotPersistedException {		
		new ClientesBaja().delete(id);		
	}
	@Override
	public Cliente findById(Long id) throws NotPersistedException {
		return new ClientesBuscar().find(id);		
	}
	@Override
	public List<Piso> consultaPisosPorCiudad(String ciudad) throws NotPersistedException {		
		return new ClientesConsultaPorCiudad().consultaPorCiudad(ciudad);		
	}
	@Override
	public List<Piso> consultaPisoPorPrecio(double min, double max) throws NotPersistedException {		
		return new ClientesConsultaPorPrecio().consultaPorPrecio(min, max);		
	}
	@Override
	public List<PisoParaVisitar> consultaPisoVisitar(long idCliente) throws Exception{		
		return new ClientesConsultaPisoVisitar().consultaPisoVisitar(idCliente);	
	}
	@Override
	public void solicitarVisita(long idPiso, long idCliente) throws NotPersistedException {		
		new ClientesSolicitarVisita().solicitarVisita(idPiso, idCliente);		
	}
	@Override
	public void confirmarVisita(long idPiso, long idCliente) throws NotPersistedException {	
		new ClientesConfirmarVisita().confirmarVisita(idPiso, idCliente);	
	}
	@Override
	public void deleteCliente(Long id) throws NotPersistedException {
		// TODO Auto-generated method stub
		new ClientesBaja().delete(id);
	}
	
}
