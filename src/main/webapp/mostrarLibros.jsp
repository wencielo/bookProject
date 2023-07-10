<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.List"
		 import= "models.Book" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Libros</title>
</head>
<body>
<a href="Index.jsp">Volver Inicio</a>
<h1>Lista de Libros</h1>
	<%
		List<Book> listaBooks = (List)request.getSession().getAttribute("listaBooks");
		for(Book bo: listaBooks){
	%>
			<h3>id: <%= bo.getId() %></h3>
			<h3>isbn: <%= bo.getIsbn() %></h3>
			<h3>titulo: <%= bo.getTitulo() %></h3>
			<h3>anio: <%= bo.getAnio() %></h3>
			<h3>ejemplares: <%= bo.getEjemplares() %></h3>

			<br>
				<form action="SvBook" method="POST">
					<input type="hidden" name="action" value="eliminar">
					<input type="hidden" name="id" value=<%= bo.getId() %>>
					<button type="submit">Eliminar</button>
				</form>

				<br>
				
				<form action="SvBook" method="GET">
					<input type="hidden" name="action" value="actualizar">
					<input type="hidden" name="id" value=<%= bo.getId() %>>
					<button type="submit">Editar</button>				
				</form>			
		<% } %>
</body>
</html>