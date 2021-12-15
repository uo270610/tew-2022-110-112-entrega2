/**
 * 
 */


function Model() {
	//Lista de agentes.
	 this.LAgentes= null;
	 
	
	//Carga los datos del servicio sobreescribiendo el dato this.LAgentes.
	this.load = function() {
		this.LAgentes = AgentesServicesRs.getAgentes();
	}

	this.comprueba = function (user, pass) {
	 	   for(var a in this.LAgentes){
	 		   var agente = this.LAgentes[a];
	            if((this.LAgentes[a].login == user) && (this.LAgentes[a].passwd == pass)){
	            	localStorage.setItem('agente', agente.id);
			    	
	                    return true;
	                }
	            
	            }
	        }
	        
	  

};


function Controller(varmodel) {
	var that = this;
	this.model = varmodel;
	this.init = function() {
		// Cargamos la lista de agentes del servicio
		
		this.model.load();
		$("#btnEnviar").click(
				function(event){
			var user=$("#username").val();
			var pass=$("#passwd").val();
		    var bool = that.model.comprueba(user,pass);
		    if (bool){
		    	
		    	window.location.href="indexAgente.html";
		    	return false;
		    }
		    else alert("Login incorrecto");
		    
		});
		
		$("#logout").click(
				function(event){
			localStorage.removeItem('agente');
			window.location.href="login.html";
				})
		}
			
};	
$(function() {
	// Creamos el modelo con los datos y la conexión al servicio web.
	var model = new Model();
	// Creamos el controlador
	var control = new Controller(model);
	// Iniciamos la aplicación
	control.init();
});