package connections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {
	
	private static final String PERSISTENCE_UNIT_NAME ="miUnidad";	
	private static EntityManagerFactory entityManagerFactory; //Creamos nuestro gestor o fabrica de entidades
	
	public static EntityManager getEntityManager()	{
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return entityManagerFactory.createEntityManager();
	}
	
	public static void closeEntityManagerFactory(){
		if (entityManagerFactory != null ) {
			entityManagerFactory.close();
		}
	}
}
