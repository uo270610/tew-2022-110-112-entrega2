package com.tew.presentation;
import java.io.Serializable;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import com.tew.business.LoginService;
import com.tew.infrastructure.Factories;
import com.tew.model.ReturnVerify;
import com.tew.persistence.exception.NotPersistedException;

@SessionScoped
@ManagedBean(name = "login")
public class BeanLogin implements Serializable {
	private static final long serialVersionUID = 33333333L;
	private String email = "";
	private String password = "";
	
	
	
	//AQUI FALTA CODIGO

	public String getEmail() {
		return email;
	}
	public void setEmail(String pepe) {
		this.email = pepe;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	
	//lo de arriba ha sido añadiod por mi
	
	
	public String verify() throws NotPersistedException {
		// necesario para accede a msgs y a los mensajes en español e ingles de los
		// ficheros
		// de propiedades
		FacesContext jsfCtx = FacesContext.getCurrentInstance();
		ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msgs");
		FacesMessage msg = null;
		LoginService login = Factories.services.createLoginService();
		ReturnVerify user = login.verify(email, password);
		
		

		if (user.getUsuario() != null) {
			putUserInSession(user);
			if (user.getTipoUsuario()=="AGENTE") {
				return "success_agent";
			}
			else {
				return "success_client";
			}
			
		}
		// si el usuario no se encuentra
		// se prepara el mensaje que saldra en la vista del cliente
		msg = new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("login_form_result_error"), null);
		// se añade al element con id=”msg”
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "login";
	}
	
	private void putUserInSession(ReturnVerify user) {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put(user.getTipoUsuario(), user.getUsuario());
	}
	
	public String logoutCliente() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.remove("CLIENTE");
		return "exito";
		
	}
	
	public String logoutAgente() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.remove("AGENTE");
		return "exito";
	}
	
	
	
}