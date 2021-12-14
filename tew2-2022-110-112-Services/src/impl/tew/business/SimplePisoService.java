package impl.tew.business;

import java.util.List;

import com.tew.business.PisoService;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Piso;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

import impl.tew.business.classes.PisosAlta;
import impl.tew.business.classes.PisosBaja;
import impl.tew.business.classes.PisosBuscar;
import impl.tew.business.classes.PisosListado;
import impl.tew.business.classes.PisosUpdate;

public class SimplePisoService implements PisoService {

	public List<Piso> getPisos() throws Exception {
		
		return new PisosListado().getPisos();
		
	}
	
	public void deletePiso(Long id) throws NotPersistedException {
		
		new PisosBaja().delete(id);
		
	}
	
	public Piso findById(Long id) throws NotPersistedException {
		
		return new PisosBuscar().find(id);
		
	}
	
	public void savePiso(Piso piso) throws AlreadyPersistedException {
		
		new PisosAlta().save(piso);
		
	}
	
	public void updatePiso(Piso piso) throws EntityNotFoundException {
		
		new PisosUpdate().update(piso);
		
	}
	
}
