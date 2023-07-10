<%@ page import= "models.Book" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

		 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Libro</title>
</head>
<body>
<a href="mostrarLibros.jsp">Volver</a>
	<h1>Modificar Libro</h1>
	<% Book bo =  (Book) request.getSession().getAttribute("book");%>
	
	<form action="SvBook" method = "POST">
		<input type="hidden" name="action" value="actualizar">
		<input type="hidden" name="id" value=<%= bo.getId() %>>
		<label>Isbn: <input type ="text" name="isbn" value=<%= bo.getIsbn()%>> </label>
		<label>Titulo: <input type ="text" name="titulo" value="<%= bo.getTitulo()%>"> </label>
		<label>Año: <input type ="text" name="anio" value=<%= bo.getAnio()%>> </label>
		<label>Ejemplares: <input type ="text" name="ejemplares" value=<%= bo.getEjemplares()%>> </label>
		<input type="hidden" name="alta" value=<%= bo.getAlta()%>>
		<button type="submit">Guardar</button>	
	</form>
</body>
</html>