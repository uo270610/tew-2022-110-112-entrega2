package com.tew.persistence;

import java.util.List;

import com.tew.model.PisoParaVisitar;
import com.tew.persistence.exception.NotPersistedException;

public interface PisoParaVisitarDao {
	
	public List<PisoParaVisitar> getPisosParaVisitar();
	void delete(Long idp, Long idc) throws NotPersistedException;
	
}
