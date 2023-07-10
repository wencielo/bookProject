package servlets;

import models.Book;
import services.BookServicio;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvBook", urlPatterns= "/SvBook")
public class SvBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BookServicio bookServ;
    
    public SvBook() {
        super();
        bookServ = new BookServicio();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action == null) {
			List<Book> listaBooks = bookServ.mostrarBooks();
			
			HttpSession miSession = request.getSession();
			miSession.setAttribute("listaBooks", listaBooks);			
			response.sendRedirect("mostrarLibros.jsp");
			
		}else if (action.equals("actualizar")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Book book = bookServ.obtenerBook(id);
			
			HttpSession miSession = request.getSession();
			miSession.setAttribute("book", book);
			response.sendRedirect("editarBook.jsp");
	    }
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equals("eliminar")) {
			Integer id = Integer.parseInt(request.getParameter("id")); 
			bookServ.borrarBook(id);
			response.sendRedirect("Index.jsp");
			
		}else if(action.equals("crear")) {
			Book book = new Book();
			
			Long isbn = Long.parseLong (request.getParameter("isbn"));
			String titulo = request.getParameter("titulo");
			Integer anio = Integer.parseInt(request.getParameter("anio"));
			Integer ejemplares = Integer.parseInt(request.getParameter("ejemplares"));
			//Boolean alta = request.getParameter("alta");
			
			bookServ.crearBook(isbn, titulo, anio, ejemplares);
			
			response.sendRedirect("Index.jsp");
			
		}else if(action.equals("actualizar")) {			
			Book book = (Book)request.getSession().getAttribute("book");
			
			book.setIsbn(Long.parseLong (request.getParameter("isbn")));
			book.setTitulo(request.getParameter("titulo"));
			book.setAnio(Integer.parseInt(request.getParameter("anio")));
			book.setEjemplares(Integer.parseInt(request.getParameter("ejemplares")));
			
			bookServ.editarBook(book);
			response.sendRedirect("Index.jsp");
		}	
	}
		
}
