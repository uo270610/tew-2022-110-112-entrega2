package impl.tew.business.classes;

import java.util.List;

import com.tew.infrastructure.Factories;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.PisoParaVisitarDao;

public class PisosParaVisitarListado {

	public List<PisoParaVisitar> getPisosParaVisitar() throws Exception {
		PisoParaVisitarDao dao = Factories.persistence.createPisoParaVisitarDao();
		return  dao.getPisosParaVisitar();
	}
	
}
