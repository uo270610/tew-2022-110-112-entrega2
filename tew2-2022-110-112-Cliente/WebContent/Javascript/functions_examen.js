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
		 for(i in this.tbPisos){
			 this.precioArray[this.n] = this.tbPisos[i]["precio"];
			 this.n=this.n+1;
		 }
	 }
}
function Controller(varmodel,varview) {
	var that = this;
	this.model = varmodel;
	this.view=varview;
	this.init = function() {
		localStorage.setItem('maximo', Math.max(...this.model.precioArray)*2/3);
		localStorage.setItem('minimo', Math.min(...this.model.precioArray)/3);
	}
}

function View(){
	
}



$(function() {
	// Creamos el modelo con los datos y la conexión al servicio web.
	var model = new Model();
	model.load();
	model.precios();
	var view = new View();
	// Creamos el controlador
	var control = new Controller(model, view);
	// Iniciamos la aplicación
	control.init();
});