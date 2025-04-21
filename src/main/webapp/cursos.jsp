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

	<div class="container-fluid">

		<div class="row">
			<div class="col-md-4">
				<form>
					<div class="form-group">
						<label for="txtCodigo">Codigo</label> <input type="text"
							class="form-control" id="txtCodigo">
					</div>
					<div class="form-group">
						<label for="txtNombre">Nombre</label> <input type="text"
							class="form-control" id="txtNombre">
					</div>

					<div class="form-group">
						<label for="txtNivel">Nivel</label> <input type="text"
							class="form-control" id="txtNivel">
					</div>
					<div class="form-group">
						<label for="txtProfesor">Profesor</label> <input type="text"
							class="form-control" id="txtProfesor">
					</div>

					<button id="btnProcesar" type="button" class="btn btn-success">Guardar</button>
					<button id="btnLimpiar" type="button" class="btn btn-danger">Cancelar</button>
					<!--  
						<button id="btnConsultar" type="button" class="btn btn-success">Consultar</button>
					-->
				</form>


			</div>

			<div class="col-md-8">

				<table class="table table-dark">
					<thead>
						<tr>
							<th scope="col">Codigo</th>
							<th scope="col">Nombre</th>
							<th scope="col">Nivel</th>
							<th scope="col">Profesor</th>
							<th>Opciones</th>
						</tr>
					</thead>
					<tbody id="table_datos">
					</tbody>
				</table>

				
			</div>
		</div>

	</div>









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

<script src="assets/js/cursos.js?v=1.60" type="text/javascript"></script>

</html>


