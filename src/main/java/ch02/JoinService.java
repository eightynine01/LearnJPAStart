package ch02;

import javax.persistence.EntityManager;

/**
 * Created by TaeHwan
 * 2017. 7. 11. PM 1:47
 */
public class JoinService {
    public boolean userIsNull(User user){
        return user != null;
    }
    public void join(User user){
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        try{
            User found = em.find(User.class, user.getEmail());
            if(userIsNull(found)) throw new DuplicateEmailException();
            em.persist(user);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
            throw ex;
        }finally {
            em.close();
        }
    }
}
