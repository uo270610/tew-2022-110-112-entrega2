package com.tew.presentation;
import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.tew.model.Piso;

@ManagedBean(name="piso")
@SessionScoped
public class BeanPiso extends Piso implements Serializable {
	private static final long serialVersionUID = 55556L;
	
	public BeanPiso() {
		iniciaPiso(null);
	}

	//Este método es necesario para copiar el alumno a editar cuando
	//se pincha el enlace Editar en la vista listado.xhtml. Podría sustituirse 
	//por un método editar en BeanAlumnos.
		public void setPiso(Piso pisin) {
			setId(pisin.getId());
			setIdAgente(pisin.getIdAgente());
			setPrecio(pisin.getPrecio());
			setEstado(pisin.getEstado());
			setCiudad(pisin.getCiudad());
			setAno(pisin.getAno());
		}
	//Iniciamos los datos del alumno con los valores por defecto 
	//extraídos del archivo de propiedades correspondiente
	    public void iniciaPiso(ActionEvent event) {
		    FacesContext facesContext = FacesContext.getCurrentInstance();
	    	    ResourceBundle bundle = 
	 	        facesContext.getApplication().getResourceBundle(facesContext, "msgs");
	    	    setId(null);
	    	    setIdAgente(null);
	    	    setPrecio(1);
	    	    setEstado(1);
	    	    setCiudad(bundle.getString("valorDefectoCiudad"));
	    	    setAno(1);
		  }	       
}