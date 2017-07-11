package ch02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by TaeHwan
 * 2017. 7. 11. PM 1:38
 */
public class EMF {
    private static EntityManagerFactory emf;
    public static void init(){
        emf = Persistence.createEntityManagerFactory("jpastart");
    }
    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
    public static void close(){
        emf.close();
    }
}
