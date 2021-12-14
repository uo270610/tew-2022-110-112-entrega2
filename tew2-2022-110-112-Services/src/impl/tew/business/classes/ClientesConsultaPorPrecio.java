package impl.tew.business.classes;

import java.util.List;

import com.tew.infrastructure.Factories;
import com.tew.model.Piso;
import com.tew.persistence.ClienteDao;
import com.tew.persistence.exception.NotPersistedException;

public class ClientesConsultaPorPrecio {
	
	public List<Piso> consultaPorPrecio(double min, double max) throws NotPersistedException {
		ClienteDao dao = Factories.persistence.createClienteDao();
		List<Piso> pisos = dao.consultaPisoPorPrecio(min, max);
		if (pisos==null) {
			throw new NotPersistedException("No se ha encontrado ningun piso");
		}
		return pisos;
	}
	
}
