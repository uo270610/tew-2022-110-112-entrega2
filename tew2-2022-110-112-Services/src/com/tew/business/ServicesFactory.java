package com.tew.business;

public interface ServicesFactory {
	
	LoginService createLoginService();
	ClienteService createClienteService();
	AgenteService createAgenteService();
	PisoService createPisoService();
	PisoParaVisitarService createPisoParaVisitarService();
	
}
