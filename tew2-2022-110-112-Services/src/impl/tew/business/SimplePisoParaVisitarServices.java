package impl.tew.business;

import java.util.List;

import com.tew.business.PisoParaVisitarService;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.exception.NotPersistedException;

import impl.tew.business.classes.PisosParaVisitarBaja;
import impl.tew.business.classes.PisosParaVisitarListado;

public class SimplePisoParaVisitarServices implements PisoParaVisitarService{

	@Override
	public List<PisoParaVisitar> getPisosParaVisitar() throws Exception {
		return new PisosParaVisitarListado().getPisosParaVisitar();		
	}
	
	public void deletePisoParaVisitar(long idp, long idc) throws NotPersistedException {
		new PisosParaVisitarBaja().delete(idp, idc);
	}

	@Override
	public List<PisoParaVisitar> getPisosParaVisitarAgente(long idAgente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PisoParaVisitar findById(long idCliente, long idPiso) throws NotPersistedException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePisoParaVisitar(PisoParaVisitar alumno) throws EntityAlreadyExistsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePisoParaVisitar(PisoParaVisitar alumno) throws NotPersistedException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PisoParaVisitar> getPisosParaVisitarCliente(long idAgente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
