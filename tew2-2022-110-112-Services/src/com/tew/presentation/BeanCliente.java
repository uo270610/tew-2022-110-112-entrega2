package com.tew.presentation;
import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tew.model.Cliente;

@ManagedBean(name="cliente")
@SessionScoped
public class BeanCliente extends Cliente implements Serializable {
	private static final long serialVersionUID = 55556L;
	
	public BeanCliente() {
		iniciaCliente(null);
	}

//Iniciamos los datos del alumno con los valores por defecto 
//extraÃ­dos del archivo de propiedades correspondiente
    public void iniciaCliente(ActionEvent event) {
	    FacesContext facesContext = FacesContext.getCurrentInstance();
    	    ResourceBundle bundle = 
 	        facesContext.getApplication().getResourceBundle(facesContext, "msgs");
    	    setId(null);
    	    setLogin(bundle.getString("valorDefectoCorreo"));
    	    setNombre(bundle.getString("valorDefectoNombre"));
    	    setApellidos(bundle.getString("valorDefectoApellidos"));
    	    setEmail(bundle.getString("valorDefectoCorreo"));
    	    setPasswd(bundle.getString("valorDefectoContraseña"));
	 }	      
}