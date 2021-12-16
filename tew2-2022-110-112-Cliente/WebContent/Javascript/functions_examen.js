/**
 * 
 */

function Model() {
	//variable Piso.
	 this.piso= null;
	 this.IdArray = [];
	 this.tbPisos = null;
	 
	 this.load = function() {
		this.tbPisos = PisosServicesRs.getPisos();
	 }
}
function Controller(varmodel,varview) {
	
}

function View(){
	
}



$(function() {
	// Creamos el modelo con los datos y la conexión al servicio web.
	var model = new Model();
	model.load();
	var view = new View();
	// Creamos el controlador
	var control = new Controller(model, view);
	// Iniciamos la aplicación
	control.init();
});