package com.tew.presentation;
import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tew.business.PisoParaVisitarService;
import com.tew.infrastructure.Factories;
import com.tew.model.Agente;
import com.tew.model.Cliente;
import com.tew.model.Piso;
import com.tew.model.PisoParaVisitar;

@ManagedBean
@SessionScoped
public class BeanPisosParaVisitas implements Serializable{
	      private static final long serialVersionUID = 55555L;
		  // Se añade este atributo de entidad para recibir el alumno concreto selecionado de la tabla o de un formulario
	      // Es necesario inicializarlo para que al entrar desde el formulario de AltaForm.xml se puedan
	      // dejar los avalores en un objeto existente.
	     
		
          private PisoParaVisitar[] pisosParaVisitar = null;
          
          private PisoParaVisitar[] pisosParaVisitarAgente= null;
          
          private PisoParaVisitar[] pisosParaVisitarCliente = null;
          
          private Agente agentin = new Agente();
          private Cliente clientin = new Cliente();
          private PisoParaVisitar pisazo= new PisoParaVisitar();
          
        //uso de inyección de dependencia
          @ManagedProperty(value="#{pisoparavisita}") 
          private BeanPisoParaVisita pisoParaVisitar;
          public BeanPisoParaVisita getAlumno() { return pisoParaVisitar; }
          public void setAlumno(BeanPisoParaVisita pisin) {this.pisoParaVisitar = pisin;}
          
          
         /* public BeanAlumnos()
          {
        	  iniciaAlumno(null);
          }*/
		  
		  public PisoParaVisitar[] getPisosParaVisitar () {
			    return(pisosParaVisitar);
			  }
	      
	       public void setPisosParaVisitar(PisoParaVisitar[] pisinos) {
				  this.pisosParaVisitar = pisinos;
		     }  
	       
	       public PisoParaVisitar[] getPisosParaVisitarCliente () {
			    return(pisosParaVisitarCliente);
			  }
	      
	       public void setPisosParaVisitarCliente(PisoParaVisitar[] pisinos) {
				  this.pisosParaVisitarCliente = pisinos;
		     } 
	       
	       public PisoParaVisitar[] getPisosParaVisitarAgente () {
			    return(pisosParaVisitarAgente);
			  }
	      
	       public void setPisosParaVisitarAgente(PisoParaVisitar[] pisinos) {
				  this.pisosParaVisitarAgente = pisinos;
		     }
	       
	       /*
	       public void iniciaAlumno(ActionEvent event) {
	    	   FacesContext facesContext = FacesContext.getCurrentInstance();
	    	 //Obtenemos el archivo de propiedades correspondiente al idioma que
	    	 //tengamos seleccionado y que viene envuelto en facesContext
	    	 ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "msgs");
	    	 piso.setId(null);
	    	 piso.setIduser(bundle.getString("valorDefectoUserId"));
	    	 piso.setNombre(bundle.getString("valorDefectoNombre"));	    	    
	    	 piso.setApellidos(bundle.getString("valorDefectoApellidos"));
	    	 piso.setEmail(bundle.getString("valorDefectoCorreo"));      
	       }
	       
	       */
	       
	       
	       public String listado() {
		       PisoParaVisitarService service;
				  try {
				  // Acceso a la implementacion de la capa de negocio 
					// a trav��s de la factor��a
					service = Factories.services.createPisoParaVisitarService();
					// De esta forma le damos informaci��n a toArray para poder hacer el casting a Alumno[]
					pisosParaVisitar = (PisoParaVisitar [])service.getPisosParaVisitar().toArray(new PisoParaVisitar[0]);
					
					return "exito";
					
				  } catch (Exception e) {
					e.printStackTrace();  
					return "error";
				  }
				  
		 	  }
	       
	       
	       public String listadoAgente() {
		       PisoParaVisitarService service;
				  try {
				  // Acceso a la implementacion de la capa de negocio 
					// a trav��s de la factor��a
					service = Factories.services.createPisoParaVisitarService();
					// De esta forma le damos informaci��n a toArray para poder hacer el casting a Alumno[]
					agentin = (Agente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new String("AGENTE"));
					pisosParaVisitarAgente = (PisoParaVisitar [])service.getPisosParaVisitarAgente(agentin.getId()).toArray(new PisoParaVisitar[0]);
					
					return "exito";
					
				  } catch (Exception e) {
					e.printStackTrace();  
					return "error";
				  }
				  
		 	  }
	       
	       public String listadoCliente() {
		       PisoParaVisitarService service;
				  try {
				  // Acceso a la implementacion de la capa de negocio 
					// a trav��s de la factor��a
					service = Factories.services.createPisoParaVisitarService();
					// De esta forma le damos informaci��n a toArray para poder hacer el casting a Alumno[]
					clientin = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new String("CLIENTE"));
					pisosParaVisitarCliente = (PisoParaVisitar [])service.getPisosParaVisitarCliente(clientin.getId()).toArray(new PisoParaVisitar[0]);
					
					return "exito";
					
				  } catch (Exception e) {
					e.printStackTrace();  
					return "error";
				  }
				  
		 	  }
	       
	       public String baja(PisoParaVisitar alumno) {
		       PisoParaVisitarService service;
				  try {
				  // Acceso a la implementacion de la capa de negocio 
					// a trav��s de la factor��a
					service = Factories.services.createPisoParaVisitarService();
			      //Aliminamos el alumno seleccionado en la tabla
					service.deletePisoParaVisitar(alumno.getidCliente(), alumno.getidPiso());
				  //Actualizamos el javabean de alumnos inyectado en la tabla.
					pisosParaVisitar = (PisoParaVisitar [])service.getPisosParaVisitar().toArray(new PisoParaVisitar[0]);
					return "exito";
					
				  } catch (Exception e) {
					e.printStackTrace();  
					return "error";
				  }
				  
		 	  }
	       public String edit() {
		       PisoParaVisitarService service;
				  try {
				  // Acceso a la implementacion de la capa de negocio 
					// a trav��s de la factor��a
					service = Factories.services.createPisoParaVisitarService();
			      //Recargamos el alumno seleccionado en la tabla de la base de datos por si hubiera cambios.
					pisoParaVisitar = (BeanPisoParaVisita) service.findById(pisoParaVisitar.getidCliente(), pisoParaVisitar.getidPiso());
					return "exito";
					
				  } catch (Exception e) {
					e.printStackTrace();  
					return "error";
				  }
				  
		 	  }
	       
	       public String salva() {
		       PisoParaVisitarService service;
				  try {
				  // Acceso a la implementacion de la capa de negocio 
					// a trav��s de la factor��a
					service = Factories.services.createPisoParaVisitarService();
			      //Salvamos o actualizamos el alumno segun sea una operacion de alta o de edici��n
					if (pisoParaVisitar.getidPiso() == null) {
						service.savePisoParaVisitar(pisoParaVisitar);
					}
					else {
						service.updatePisoParaVisitar(pisoParaVisitar); 
					} 
					//Actualizamos el javabean de alumnos inyectado en la tabla
					pisosParaVisitar = (PisoParaVisitar [])service.getPisosParaVisitar().toArray(new PisoParaVisitar[0]);
					return "exito";
					
				  } catch (Exception e) {
					  e.printStackTrace();
					return "error";
				  }
				  
		 	  }
	       
	       
	       
	       
	       public String nuevaVisita(Piso pisin) {
	    	   PisoParaVisitarService service;
	    	   pisazo.setEstado(1);
	    	   pisazo.setFechaHoraCita(1);
	    	   pisazo.setidPiso(pisin.getId());
	    	   clientin = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new String("CLIENTE"));
	    	   pisazo.setidCliente(clientin.getId());
	    	   
				  try {
				  // Acceso a la implementacion de la capa de negocio 
					// a trav��s de la factor��a
					service = Factories.services.createPisoParaVisitarService();
			      //Aliminamos el alumno seleccionado en la tabla
					service.savePisoParaVisitar(pisazo);
				  //Actualizamos el javabean de alumnos inyectado en la tabla.
					pisosParaVisitar = (PisoParaVisitar [])service.getPisosParaVisitar().toArray(new PisoParaVisitar[0]);
					return "exito";
					
				  } catch (Exception e) {
					e.printStackTrace();  
					return "error";
				  }
				  
	       }
	       
	       
	       
	       
	       
	       
	       //este metodo no se ni pa que vale
	       
	      
	      
	     //Se inicia correctamente el MBean inyectado si JSF lo hubiera crea
	     //y en caso contrario se crea. (hay que tener en cuenta que es un Bean de sesión)
	     //Se usa @PostConstruct, ya que en el contructor no se sabe todavía si el Managed Bean
	     //ya estaba construido y en @PostConstruct SI.
	     @PostConstruct
	     public void init() {    	  
	       System.out.println("BeanPisosParaVisitas - PostConstruct"); 
	       //Buscamos el alumno en la sesión. Esto es un patrón factoría claramente.
	       pisoParaVisitar = (BeanPisoParaVisita) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(new String("pisoparavisitar"));
	       //si no existe lo creamos e inicializamos
	       if (pisoParaVisitar == null) { 
	         System.out.println("BeanPisosParaVisitas - No existia");
	         pisoParaVisitar = new BeanPisoParaVisita();
	         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put( "pisoparavisitar", pisoParaVisitar);
	       }
	     }
	     @PreDestroy
	     public void end()  {
	         System.out.println("BeanPisosParaVisitas - PreDestroy");
	     }

	}

