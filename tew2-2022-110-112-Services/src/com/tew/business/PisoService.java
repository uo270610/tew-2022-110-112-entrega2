package com.tew.business;

import java.util.List;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Piso;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

public interface PisoService {

	List<Piso> getPisos() throws Exception;
	void deletePiso(Long id) throws NotPersistedException;
	Piso findById(Long id) throws NotPersistedException;
	void savePiso(Piso alumno) throws AlreadyPersistedException;
	void updatePiso(Piso alumno) throws EntityNotFoundException;
	
}
