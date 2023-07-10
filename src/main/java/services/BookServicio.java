package services;

import repositories.BookDAO;
import java.util.List;

import models.Book;

public class BookServicio {

	BookDAO bookDao;

	public BookServicio() {
		super();
		bookDao = new BookDAO();
	}

	public void crearBook(Long isbn, String titulo, Integer anio, Integer ejemplares) {
		Book book = new Book();
		
		book.setIsbn(isbn);
		book.setTitulo(titulo);
		book.setAnio(anio);
		book.setEjemplares(ejemplares);
		book.setAlta(true);
		
		bookDao.guardarBook(book);
	}
	
	public Book obtenerBook(Integer id) {
		return bookDao.buscarBookPorId(id);
	}
	
	public List<Book> mostrarBooks(){
		List<Book> listarBooks = bookDao.obtenerBook();
		return listarBooks;
	}
	
	public void editarBook(Book book) {
		bookDao.actualizarBook(book);
	}
	
	public void borrarBook(Integer id) {         
		bookDao.eliminarBook(id);
	}
}
