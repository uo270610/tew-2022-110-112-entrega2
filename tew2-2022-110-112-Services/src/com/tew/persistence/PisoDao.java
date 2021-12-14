package com.tew.persistence;

import java.util.List;

import com.tew.model.Piso;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

public interface PisoDao {
	
	List<Piso> getPisos();
	void save(Piso a) throws AlreadyPersistedException;
	void update(Piso a) throws NotPersistedException;
	void delete(Long id) throws NotPersistedException;
	Piso findById(Long id);
	
}
