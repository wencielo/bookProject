package repositories;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import connections.Conexion;
import models.Book;

public class BookDAO {
	
	EntityManager entity;
    
	public BookDAO() {
	}
	
	public void guardarBook(Book book) {
		entity = Conexion.getEntityManager();
		try {
		entity.getTransaction().begin();
		entity.persist(book);
		entity.getTransaction().commit();
		} finally {
			if (entity != null) {
				entity.close();
			}
		}
	}
	
	public Book buscarBookPorId(Integer id) {
		entity = Conexion.getEntityManager();
		Book book = new Book();
		book = entity.find(Book.class, id);
		return book;
		
	}
	
	public List<Book> obtenerBook(){
		entity = Conexion.getEntityManager();
		try {
			List<Book> listaBooks = new ArrayList<>();
			Query sql = entity.createQuery("SELECT a FROM Book a");
			return listaBooks =sql.getResultList();
		} finally {
			if (entity != null) {
				entity.close();
			}
		}
	}
	
	public void eliminarBook(Integer id) {
		Book book = buscarBookPorId(id);
		try {
		entity.getTransaction().begin();
		entity.remove(book);
		entity.getTransaction().commit();
		} finally {
			if (entity != null) {
				entity.close();
			}
		}
	}
	
	public void actualizarBook(Book book) {
		entity = Conexion.getEntityManager();
		try {
			entity.getTransaction().begin();
			entity.merge(book);
			entity.getTransaction().commit();
		} finally {
			if (entity != null) {
				entity.close();
			}
		}
	}
	
	public void cerrarconexion() {
		Conexion.closeEntityManagerFactory();
	}
	

}
