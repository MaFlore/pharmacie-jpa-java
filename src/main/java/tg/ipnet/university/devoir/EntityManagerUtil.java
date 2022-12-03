package tg.ipnet.university.devoir;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerUtil {
	
  private static final EntityManagerFactory entityManagerFactory;
  
  static {
    try {
      entityManagerFactory = Persistence.createEntityManagerFactory("pharmacie");

    } catch (Throwable ex) {
      System.err.println("La création initiale de SessionFactory a échoué : " + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();

  }
}