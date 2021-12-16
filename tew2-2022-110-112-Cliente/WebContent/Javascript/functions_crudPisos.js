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
	
	this.EncuentraPiso=function(id_piso){
		PisosServicesRs.findById({
			id: id_piso
		});
	}     
	 
};


function Controller(varmodel,varview) {
	var that = this;
	this.model = varmodel;
	this.view=varview;
	this.init = function() {
		this.view.list(this.model.tbPisos);
		$("#btnSave").click(
				function(event){
		    piso=that.view.rellenaPisoDelFormulario();
		    that.model.AltaPiso(piso);
		    	window.location.href="listado.html";
		    	return false;
				
		});
		
		$("#botonCiudad").click(
				function(event){
					localStorage.setItem('ciudad', document.getElementById("fciudad").value);
					window.location.href="listadoPorCiudad.html";
					
		});
		
		$("#table").on("click", ".editPress", function(event){
					var id_piso = that.view.getIdPiso($(this));
					console.log(id_piso);
					piso=that.model.EncuentraPiso(id_piso);
					console.log(piso);
					that.view.rellenaTablaConPiso(piso);
				});
		
		
		$("#btnBorrar").click(
				function(evento){
					for(i=0; i < that.model.IdArray.length; i++){
						
						console.log(that.model.IdArray[i]);
						that.model.BorrarPiso(that.model.IdArray[i]);
						
						
					}
					
					window.location.href="listadoAgente.html";

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
	
	this.list = function(lista) {
		$("#tblPisos").html("");
		$("#tblPisos").html( '<thead class="thead-dark">'+
 				'<tr>'+
            	'<th scope="col">ID</th>'+
           		'<th scope="col">Precio</th>'+
           		'<th scope="col">Direccion</th>'+
           		'<th scope="col">Ciudad</th>'+
           		'<th scope="col">Año</th>'+
           		'<th scope="col">Estado</th>'+
        	'</tr>'+
        	'</thead>'+
        	'<tbody>');
		for ( var i in lista) {
			var piso = lista[i];
			$("#tblPisos tbody").append("<tr>"+
						"<td>"+piso.id+"</td>"+  
   						"<td>"+piso.precio+"</td>"+ 
   						"<td>"+piso.direccion+"</td>"+  
   						"<td>"+piso.ciudad+"</td>"+  
   						"<td>"+piso.ano+"</td>"+ 
   						"<td>"+piso.estado+"</td>"+  
   					"</tr>");
		} 
	}
	
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
	
	this.rellenaTablaConPiso = function (piso) {
		var pisin=piso;
		$("#editarid").val(pisin.id);
		$("#editaridAgente").val(pisin.idAgente);
		$("#editarprecio").val(pisin.precio);
		$("#editardireccion").val(pisin.direccion);
		$("#editarciudad").val(pisin.ciudad);
		$("#editarano").val(pisin.ano);
		$("#editarestado").val(pisin.estado);
		$("#editarfoto").val(pisin.foto);
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
	model.load();
	var view = new View();
	// Creamos el controlador
	var control = new Controller(model, view);
	// Iniciamos la aplicación
	control.init();
});