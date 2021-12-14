package com.tew.presentation;
import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import com.tew.model.PisoParaVisitar;

@ManagedBean(name="pisoparavisita")
@SessionScoped
public class BeanPisoParaVisita extends PisoParaVisitar implements Serializable {
	private static final long serialVersionUID = 55556L;
	
	public BeanPisoParaVisita() {
		iniciaPisoParaVisita(null);
	}

	//Este método es necesario para copiar el alumno a editar cuando
	//se pincha el enlace Editar en la vista listado.xhtml. Podría sustituirse 
	//por un método editar en BeanAlumnos.
		public void setPiso(PisoParaVisitar pisin) {
			setidPiso(pisin.getidPiso());
			setidCliente(pisin.getidCliente());
			setFechaHoraCita(pisin.getFechaHoraCita());
			setEstado(pisin.getEstado());
		}
	//Iniciamos los datos del alumno con los valores por defecto 
	//extraídos del archivo de propiedades correspondiente
	    public void iniciaPisoParaVisita(ActionEvent event) {
		    FacesContext facesContext = FacesContext.getCurrentInstance();
	    	    ResourceBundle bundle = 
	 	        facesContext.getApplication().getResourceBundle(facesContext, "msgs");
	    	    setidPiso(null);
	    	    setidCliente(null);
	    	    setFechaHoraCita(1);
	    	    setEstado(1);
		  }	       
}