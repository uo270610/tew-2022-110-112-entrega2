package com.tew.business;

import java.util.List;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Agente;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.exception.NotPersistedException;

public interface AgenteService {
	
	List<Agente> getAgentes() throws Exception;
	Agente findById(Long id) throws EntityNotFoundException;
	List<PisoParaVisitar> consultaPisoVisitar(long idAgente) throws Exception;
	void citarVisita(long idPiso, long idCliente) throws NotPersistedException;
	void resetDB() throws Exception;
	
}
