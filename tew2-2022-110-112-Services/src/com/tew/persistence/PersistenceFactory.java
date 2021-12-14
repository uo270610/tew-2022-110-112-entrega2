package com.tew.persistence;

public interface PersistenceFactory {
	
	ClienteDao createClienteDao();
	AgenteDao createAgenteDao();
	PisoDao createPisoDao();
	PisoParaVisitarDao createPisoParaVisitarDao();
	LoginDao createLoginDao();
	
}
