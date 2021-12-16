/**
 * 
 */


function Model() {
	//variable Piso.
	 this.piso= null;
	 this.IdArray = [];
	 
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
	
	this.BorrarPiso = function(id_piso) {
		PisosServicesRs.deletePiso({
			id : id_piso
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
		$("#editPress").click(
				function(event){
					piso=that.view.rellenaPisoDeTabla();
				});
		
		
		$("#btnBorrar").click(
				function(evento){
					for(i=0; i < that.model.IdArray.length; i++){
						
						console.log(that.model.IdArray[i]);
						that.model.BorrarPiso(that.model.IdArray[i]);
						
						
					}
					
					window.location.href="listado.html";

		});
		
		$("#table").on("click", ".marcar", function(){
			var id_piso = that.view.getIdPiso($(this));
            if(!this.checked) {
            	that.model.IdArray.splice(that.model.IdArray.indexOf(id_piso), 1 );
            }
            else {
            	that.model.IdArray.push(id_piso);
            	console.log(that.model.IdArray);
            }
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
	
	this.rellenaPisoDeTabla = function () {
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
	
	
	this.getIdPiso = function(celda) {
		// Accedemos a la fila que está por encima de esta celda
		// (closest('tr'))y despues obtenemos todas las celdas de esa fila
		// (find('tr')) y
		// nos quedamos con la segunda (get(1)) que es la contiene el "id" del
		// piso.
		var id_piso = parseInt(celda.closest('tr').find('td').get(0).innerHTML);
		return id_piso;
	}
};

$(function() {
	// Creamos el modelo con los datos y la conexión al servicio web.
	var model = new Model();
	
	var view = new View();
	// Creamos el controlador
	var control = new Controller(model, view);
	
	
	// Iniciamos la aplicación
	control.init();
});