package com.tew.presentation;

import java.io.Serializable;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tew.business.ClienteService;
import com.tew.infrastructure.Factories;
import com.tew.model.Cliente;
import com.tew.model.User;

@ManagedBean
@SessionScoped
public class BeanClientes implements Serializable {
	private static final long serialVersionUID = 55555L;
	// Se aÒade este atributo de entidad para recibir el alumno concreto
	// seleccionado
	// de la tabla o de un formulario.
	// Es necesario inicializarlo para que al entrar desde el formulario de
	// AltaForm.xhtml se puedan dejar los valores en un objeto existente.
	//private Cliente clientito = new Cliente();
	private Cliente[] clientitos = null;
	
	//uso de inyecci√≥n de dependencia
    @ManagedProperty(value="#{alumno}") 
    private BeanCliente clientito;
    public BeanCliente getCliente() { return clientito; }
    public void setAlumno(BeanCliente clientin) {this.clientito = clientin;}
	
	
	private User usuario;

	
	/*
	public BeanClientes() {
		iniciaCliente(null);
	}
	*/

	public void iniciaCliente(ActionEvent event) {
		clientito.setId(null);
		clientito.setLogin("LoginUser");
		clientito.setNombre("Nombre");
		clientito.setApellidos("Apellidos");
		clientito.setEmail("email@domain.com");
		clientito.setPasswd("password");
	}

	public Cliente getAlumno() {
		return clientito;
	}

	public void setCliente(BeanCliente clientin) {
		this.clientito = clientin;
	}

	public Cliente[] getClientes() {
		return clientitos;
	}

	public void setClientes(Cliente[] clientes) {
		this.clientitos = clientes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	//1-> Cambiar el nombre del mensaje de error que vamos a dar
	//2-> CÛmo estamos gestionando distintos errores que pueden salir? respondemos lo mismo para todos
	//3-> Deberiamos tener un metodo que compruebe que ese email no esta siendo usado y luego otro para escribir en la base?
	
	
	public String salva() {
		ClienteService service;
		// necesario para accede a msgs y a los mensajes en espaÒol e ingles de los
		// ficheros
		// de propiedades
		FacesContext jsfCtx = FacesContext.getCurrentInstance();
		ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msgs");
		FacesMessage msg = null;
		try {
			// Acceso a la implementacion de la capa de negocio
			// a travÈs de la factorÌa
			service = Factories.services.createClienteService();
			service.saveCliente(clientito);
			usuario= new User(clientito.getLogin(), clientito.getPasswd());
			putUserInSession(usuario);
			return "exito";
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("logincliente_form_result_error"), null);
			// se aÒade al element con id=îmsgî
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "error";
		}
	}
	
	private void putUserInSession(User user) {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("CLIENTE", user);
	}

	
	 //Se inicia correctamente el MBean inyectado si JSF lo hubiera crea
    //y en caso contrario se crea. (hay que tener en cuenta que es un Bean de sesi√≥n)
    //Se usa @PostConstruct, ya que en el contructor no se sabe todav√≠a si el Managed Bean
    //ya estaba construido y en @PostConstruct SI.
    @PostConstruct
    public void init() {    	  
      System.out.println("BeanClientes - PostConstruct"); 
      //Buscamos el alumno en la sesi√≥n. Esto es un patr√≥n factor√≠a claramente.
      clientito = (BeanCliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new String("cliente"));
      //si no existe lo creamos e inicializamos
      if (clientito == null) { 
        System.out.println("BeanClientes - No existia");
        clientito = new BeanCliente();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put( "cliente", clientito);
      }
    }
    @PreDestroy
    public void end()  {
        System.out.println("BeanAlumnos - PreDestroy");
    }
	
	
	
}