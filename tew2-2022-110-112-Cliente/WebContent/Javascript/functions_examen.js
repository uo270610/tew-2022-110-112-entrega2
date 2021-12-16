/**
 * 
 */

function Model() {
	//variable Piso.
	 this.piso= null;
	 this.precioArray = [];
	 this.tbPisos = null;
	 this.nmax = null;
	 this.nmin = null;
	 this.load = function() {
		this.tbPisos = PisosServicesRs.getPisos();
	 }
	 this.precios = function(){
		 this.n = 0
		 this.load();
		 for(i in tbPisos){
			 precioArray[n] = this.tbPisos[i]["precio"];
			 n=n+1;
		 }
	 }
	 this.max = function(){
		 this.nmax = Math.max(...precioArray);
	 }
	 this.max = function(){
		 this.nmin = Math.min(...precioArray);
	 }
}
function Controller(varmodel,varview) {
	var that = this;
	this.model = varmodel;
	this.view=varview;
	this.init = function() {
		$("#umbralSuperior").val(that.model.max());
		$("#umbralInferior").val(that.model.min());
	}
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