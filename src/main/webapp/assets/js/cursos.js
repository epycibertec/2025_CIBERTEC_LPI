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
			let fila = "";
			$.each(respuesta, function(indice, item) {
				fila += "<tr>";
				fila += "<td>" + item.codigo + "</td>";
				fila += "<td>" + item.nombre + "</td>";
				fila += "<td>" + item.nivel + "</td>";
				fila += "<td>" + item.profesor + "</td>";
				fila += "</tr>";
			});

			$("#table_datos").html(fila);
			
			let fila2 = "";
			$.each(respuesta, function(indice, item) {
				fila2 += `<tr>
							<td>${item.codigo}</td>
							<td>${item.nombre}</td>
							<td>${item.nivel}</td>
							<td>${item.profesor}</td>
							<td>
								<button class='btn btn-danger'>Eliminar</button>
								<button class='btn btn-warning'>Editar</button>
							<td>
						</tr>`;
			});
			$("#table_datos2").html(fila2);

		});
	});

});

















