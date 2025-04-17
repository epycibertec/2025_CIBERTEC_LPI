/**
 * 
 */
$(document).ready(function() {

	$("#btnProcesar").click(function() {
		let codigo, nombre, nivel, profesor;

		codigo = $("#txtCodigo").val();
		nombre = $("#txtNombre").val();
		nivel = $("#txtNivel").val();
		profesor = $("#txtProfesor").val();

		const parametros = {
			"cod": codigo,
			"nom": nombre,
			"niv": nivel,
			"pro": profesor
		};

		$.post("CursosServlet", parametros, function(respuesta) {
			alert(respuesta);
		});
	});

	$("#btnConsultar").click(function() {

		$.get("CursosServlet", {}, function(respuesta) {
			console.log(respuesta);
			
			
			$.each(respuesta, function(indice, item){
				alert(
					item.codigo +" - "+ item.nombre
				);
			});
			
			
			
			
		});


	});






});

















