package impl.tew.business.classes;

import com.tew.infrastructure.Factories;
import com.tew.persistence.PisoParaVisitarDao;
import com.tew.persistence.exception.NotPersistedException;

public class PisosParaVisitarBaja {

	public void delete(long idp, long idc) throws NotPersistedException {
		PisoParaVisitarDao dao = Factories.persistence.createPisoParaVisitarDao();
		try {
			dao.delete(idp, idc);
		}
		catch (NotPersistedException ex) {
			throw new NotPersistedException("Piso para visitar " + idp + "para cliente " + idc + "no eliminado", ex);
		}
	}
	
	
}
