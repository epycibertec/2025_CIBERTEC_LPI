<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mi primera pagina</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>

	<form>
		<label>Codigo</label> <input type="text" id="txtCodigo" /> <br>
		<label>Nombre</label> <input type="text" id="txtNombre" /> <br>
		<label>Nivel</label> <input type="text" id="txtNivel" /> <br> <label>Profesor</label>
		<input type="text" id="txtProfesor" />

		<button id="btnProcesar" type="button" class="btn btn-warning">Procesar</button>
		<button id="btnLimpiar" type="button" class="btn btn-danger">Limpiar</button>
		<button id="btnConsultar" type="button" class="btn btn-success">Consultar</button>
	</form>

	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">Codigo</th>
				<th scope="col">Nombre</th>
				<th scope="col">Nivel</th>
				<th scope="col">Profesor</th>
			</tr>
		</thead>
		<tbody id="table_datos">
		</tbody>
	</table>
	
	<table class="table  table-bordered">
		<thead>
			<tr>
				<th scope="col">Codigo</th>
				<th scope="col">Nombre</th>
				<th scope="col">Nivel</th>
				<th scope="col">Profesor</th>
			</tr>
		</thead>
		<tbody id="table_datos2">
		</tbody>
	</table>





</body>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
	integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
	crossorigin="anonymous"></script>

<script src="assets/js/cursos.js?v=1.30" type="text/javascript"></script>

</html>


