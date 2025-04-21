
let ES_EDITAR = false;

$(document).ready(function() {
	cargarDatos();

	$("#btnProcesar").click(function() {
		
		let codigo, nombre, nivel, profesor;
		codigo = $("#txtCodigo").val();
		nombre = $("#txtNombre").val();
		nivel = $("#txtNivel").val();
		profesor = $("#txtProfesor").val();
		const parametros = {
			"indicador": "insertar",
			"codigo": codigo,
			"nombre": nombre,
			"nivel": nivel,
			"profesor": profesor,
			"funcion": "0" // 0=> Guardar - 1=> Editar
		};

		if (ES_EDITAR) {
			parametros.funcion=1;
		}

		console.log(parametros);
		$.post("CursosServlet", parametros, function(respuesta) {
			cargarDatos();
		});
		limpiar();
	});

	$("#btnLimpiar").click(function() {
		limpiar();
	});


	$(document).on("click", ".accion_eliminar", function() {

		let codigo = $(this).parents("tr").find("td").eq(0).html();
		const parametros = {
			"indicador": "eliminar",
			"codigo": codigo
		};
		$.post("CursosServlet", parametros, function(respuesta) {
			console.log(respuesta);
		});
	});

	$(document).on("click", ".accion_editar", function() {
		ES_EDITAR = true;
		let codigo, nombre, nivel, profesor;
		codigo = $(this).parents("tr").find("td").eq(0).html();
		nombre = $(this).parents("tr").find("td").eq(1).html();
		nivel = $(this).parents("tr").find("td").eq(2).html();
		profesor = $(this).parents("tr").find("td").eq(3).html();
		$("#txtCodigo").val(codigo);
		$("#txtNombre").val(nombre);
		$("#txtNivel").val(nivel);
		$("#txtProfesor").val(profesor);
	});
});


function cargarDatos() {
	const parametros = {
		"indicador": "listar"
	};
	$.get("CursosServlet", parametros, function(respuesta) {
		let fila2 = "";
		$.each(respuesta, function(indice, item) {
			fila2 += `<tr>
								<td>${item.codigo}</td>
								<td>${item.nombre}</td>
								<td>${item.nivel}</td>
								<td>${item.profesor}</td>
								<td>
									<button class='btn btn-danger accion_eliminar'>Eliminar</button>
									<button class='btn btn-warning accion_editar'>Editar</button>
								<td>
							</tr>`;
		});
		$("#table_datos").html(fila2);

	});
}

function limpiar() {
	$("#txtCodigo").val("");
	$("#txtNombre").val("");
	$("#txtNivel").val("");
	$("#txtProfesor").val("");
	ES_EDITAR = false;
}

















