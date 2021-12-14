package com.tew.business;

import java.util.List;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.model.PisoParaVisitar;
import com.tew.persistence.exception.NotPersistedException;

public interface PisoParaVisitarService {

	
	List<PisoParaVisitar> getPisosParaVisitar() throws Exception;
	List<PisoParaVisitar> getPisosParaVisitarAgente(long idAgente) throws Exception;
	
	
	
	//esta
	List<PisoParaVisitar> getPisosParaVisitarCliente(long idAgente) throws Exception;
	
	
	
	
	void deletePisoParaVisitar(long idCliente, long idPiso) throws NotPersistedException;
	PisoParaVisitar findById(long idCliente, long idPiso) throws NotPersistedException;
	void savePisoParaVisitar(PisoParaVisitar alumno) throws EntityAlreadyExistsException;
	void updatePisoParaVisitar(PisoParaVisitar alumno) throws NotPersistedException;
	
	
}
