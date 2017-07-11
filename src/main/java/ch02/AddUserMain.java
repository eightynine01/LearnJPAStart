package ch02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by TaeHwan
 * 2017. 7. 11. PM 1:22
 */
public class AddUserMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpastart");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            User user = new User("user@user.com","user",new Date());
            entityManager.persist(user);
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }finally {
            entityManager.close();
        }
        emf.close();
    }
}
