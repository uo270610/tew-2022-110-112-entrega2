/**
 * 
 */


function Model() {
	//variable Piso.
	 this.piso= null;
	
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


function Controller(varmodel,varview) {
	var that = this;
	this.model = varmodel;
	this.view=varview;
	this.init = function() {
		$("#btnSave").click(
				function(event){
		    piso=that.view.rellenaPisoDelFormulario();
		    that.model.AltaPiso(piso);
		    	window.location.href="listado.html";
		    	return false;
				
		});
}
			
};

function View(){
	this.rellenaPisoDelFormulario = function () {
		var piso= {
		id:1,
		idAgente:localStorage.getItem('agente'),
		precio:$("#precio").val(),
		direccion:$("#direccion").val(),
		estado:$("#estado").val(),
		ciudad:$("#ciudad").val(),
		ano:$("#ano").val(),
		foto:$("#foto").val()
		}
		return piso
	        }
}

$(function() {
	// Creamos el modelo con los datos y la conexión al servicio web.
	var model = new Model();
	
	var view = new View();
	// Creamos el controlador
	var control = new Controller(model, view);
	
	
	// Iniciamos la aplicación
	control.init();
});