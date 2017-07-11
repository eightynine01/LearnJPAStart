package ch02;

import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * Created by TaeHwan
 * 2017. 7. 11. PM 2:11
 */
public class GetUserService{
    public Optional<User> getUser(String email){
        EntityManager em = EMF.createEntityManager();
        try{
            User user = em.find(User.class, email);
            return Optional.ofNullable(user);
        }finally {
            em.close();
        }
    }
}
