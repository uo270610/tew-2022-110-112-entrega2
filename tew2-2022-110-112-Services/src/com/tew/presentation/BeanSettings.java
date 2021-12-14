package com.tew.presentation;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
@ManagedBean
@SessionScoped
public class BeanSettings implements Serializable{
	private static final long serialVersionUID = 2L; 
	private static final Locale ENGLISH = new Locale("en");
	private static final Locale SPANISH = new Locale("es"); 
	private Locale locale = new Locale("es"); 
	public Locale getLocale() { /*Habria que cambiar algo de código para coger locale del navegador la primera vez que se 
accede a getLocale(), de momento el idioma de partida “es”*/
		return(locale); 
	} 
	public void setSpanish(ActionEvent event) { 
		locale = SPANISH;
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
	public void setEnglish(ActionEvent event) { 
		locale = ENGLISH; 
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	} 
}