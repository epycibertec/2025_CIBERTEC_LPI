
$(document).ready(function() {

	$("#btnProcesar").click(function() {
		let codigo, nombre, nivel, profesor;

		codigo = $("#txtCodigo").val();
		nombre = $("#txtNombre").val();
		nivel = $("#txtNivel").val();
		profesor = $("#txtProfesor").val();

		const parametros = {
			"cod": codigo
		};

		$.post("PruebaServlet", parametros, function(respuesta) {
			console.log(respuesta);
			
			$.each(respuesta, function(posicion, item){
				alert(item.alumno);
			});
			
		});
	});

});