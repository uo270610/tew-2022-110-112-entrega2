package com.tew.persistence;

import java.util.List;

import com.tew.model.Agente;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.exception.NotPersistedException;

public interface AgenteDao {

	List<Agente> getAgentes();
	Agente findById(Long id);
	List<PisoParaVisitar> consultaPisoVisitar(long idAgente);
	void citarVisita(long idPiso, long idCliente) throws NotPersistedException;
	void resetDB() throws Exception;
	
}
