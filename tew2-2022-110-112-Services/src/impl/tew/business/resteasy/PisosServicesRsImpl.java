package impl.tew.business.resteasy;

import java.util.List;

import com.tew.business.resteasy.PisosServicesRs;
import com.tew.model.Piso;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

import impl.tew.business.classes.*;

public class PisosServicesRsImpl implements PisosServicesRs{

	@Override
	public List<Piso> getPisos() throws Exception {
		// TODO Auto-generated method stub
		try {
			return new PisosListado().getPisos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Piso findById(Long id) throws NotPersistedException {
		// TODO Auto-generated method stub
		return new PisosBuscar().find(id);
	}

	@Override
	public void deletePiso(Long id) throws NotPersistedException {
		// TODO Auto-generated method stub
		new PisosBaja().delete(id);
	}

	@Override
	public void savePiso(Piso piso) throws AlreadyPersistedException {
		// TODO Auto-generated method stub
		new PisosAlta().save(piso);
	}

	@Override
	public void updatePiso(Piso piso) throws NotPersistedException {
		// TODO Auto-generated method stub
		new PisosUpdate().update(piso);
	}

}
