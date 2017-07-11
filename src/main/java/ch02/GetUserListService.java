package ch02;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by TaeHwan
 * 2017. 7. 11. PM 2:34
 */
public class GetUserListService {
    public List<User> getAllUsers(){
        EntityManager em = EMF.createEntityManager();
        try{
            em.getTransaction().begin();
            TypedQuery<User> query =
                    em.createQuery(
                            "select u from User u order by u.name",
                            User.class);
            List<User> result = query.getResultList();
            em.getTransaction().commit();
            return result;
        }catch (Exception ex){
            em.getTransaction().rollback();
            throw ex;
        }finally {
            em.close();
        }
    }
}
