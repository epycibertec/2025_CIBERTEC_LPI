

$(document).ready(function(){
	
	
	$("#btnProcesar").click(function(){
		//alert("clic...");
		//console.log("enviando datos");
		let codigo, nombre;
		
		codigo= $("#txtCodigo").val();
		nombre= $("#txtNombre").val();
		alert("Datos enviados: " + codigo +"-Nombre: "+ nombre);	
		
		const parametros= {
			"codigo": codigo,
			"nombre": nombre,
			"apellido": "perez"
		};
		
		$.post("InicioServlet", parametros, function(respuesta){
			console.log(respuesta);
		});
		
			
	});
	
	$("#btnLimpiar").click(function(){
		//alert("clic limpiar...");
		
		$("#txtCodigo").val("");
		$("#txtNombre").val("");
		
	});
	
	
	
	
	
});