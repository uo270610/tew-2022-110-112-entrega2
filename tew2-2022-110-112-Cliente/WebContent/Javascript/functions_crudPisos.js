/**
 * 
 */


function Model() {
	//variable Piso.
	 this.piso= null;
	 

	this.rellenaPisoDelFormulario = function () {
		var piso= {
		id:1,
		idAgente:localStorage.getItem('agente'),
		precio:$("#precio").val(),
		direccion:$("#direccion").val(),
		ciudad:$("#ciudad").val(),
		anyo:$("#ano").val(),
		estado:$("#estado").val(),
		foto:$("#foto").val()
		}
		return piso
	        }
	
	this.AltaPiso = function(piso){
		PisosServicesRs.savePiso({
			$entity:piso,
			$contentType:"application/json"
		});
	}
	
	this.EditarPiso=function(piso){
		PisosServicesRs.updatePiso({
			$entity:piso,
			$contentType:"application/json"
		});
	}
	        
	  

};


function Controller(varmodel) {
	var that = this;
	this.model = varmodel;
	this.init = function() {
		$("#btnSave").click(
				function(event){
		    piso=that.model.rellenaPisoDelFormulario();
		    that.model.AltaPiso(piso);
		    	window.location.href="listado.html";
		    	return false;
				
		});
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