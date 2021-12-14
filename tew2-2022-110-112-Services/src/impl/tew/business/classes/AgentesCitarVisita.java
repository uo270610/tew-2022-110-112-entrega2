package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.persistence.AgenteDao;
import com.tew.persistence.exception.NotPersistedException;

public class AgentesCitarVisita {

		public void citarVisita(long idPiso, long idCliente) throws NotPersistedException {
			
			AgenteDao dao = Factories.persistence.createAgenteDao();
			dao.citarVisita(idPiso, idCliente);
			
		}
		
}
