package impl.tew.business.classes;

import java.util.List;

import com.tew.infrastructure.Factories;
import com.tew.model.Piso;
import com.tew.persistence.PisoDao;

public class PisosListado {

	public List<Piso> getPisos() throws Exception {
		
		PisoDao dao = Factories.persistence.createPisoDao();
		return  dao.getPisos();
	
	}
	
}
