package ch02;

import javax.persistence.EntityManager;

/**
 * Created by TaeHwan
 * 2017. 7. 11. PM 2:43
 */
public class WithdrawService {
    public void withdraw(String email){
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        try {
            User user = em.find(User.class, email);
            if(user == null){
                throw new UserNotFoundException();
            }
            em.remove(user);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
            throw ex;
        }finally {
            em.close();
        }
    }
}
