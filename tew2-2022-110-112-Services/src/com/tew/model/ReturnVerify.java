package com.tew.model;

public class ReturnVerify {

	private User usuario;
    private String clase;
    // IMPORTANTE, LA STRING TENDRA QUE SER 
    // "AGENTE" O "CLIENTE" PARA QUE FUNCIONEN LOS CHECKS POSTERIORES

    public User getUsuario() {
    	try{
    		return usuario;
    	}
    	catch(Exception e) {
    			return null;
    	}
    }

    public String getTipoUsuario() {
        return clase;
    }
    
    public void setUsuario(User usador) {
    	this.usuario=usador;
    }
    
    public void setClase(String clasecita) {
    	this.clase=clasecita;
    }
}
	
