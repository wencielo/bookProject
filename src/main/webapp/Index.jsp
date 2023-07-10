<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Administración de Libros</title>
	</head>
	<body>
		<h1>Agregar Libro</h1>
		
		<form action="SvBook" method = "POST">
			<input type="hidden" name="action" value="crear">
			<label>Id: <input type ="text" name="id"> </label>
			<label>Isbn: <input type ="text" name="isbn"> </label>
			<label>Titulo: <input type ="text" name="titulo"> </label>
			<label>Año: <input type ="text" name="anio"> </label>
			<label>Ejemplares: <input type ="text" name="ejemplares"> </label>
			<label>Alta: <input type ="text" name="alta"> </label>
			<button type="submit">Enviar</button>	
		</form>
		<br>
		<br>
		<form action="SvBook" method="GET">
			<h4>Hacer click para ver los libros</h4>
			<button type="submit">Mostrar Libros</button>	
		</form>
	</body>
</html>