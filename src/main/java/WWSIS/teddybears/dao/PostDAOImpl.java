package WWSIS.teddybears.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import WWSIS.teddybears.model.Post;


@Transactional
public class PostDAOImpl implements PostDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Post> getAllUsersPosts(int userID)
    {
        Query query = entityManager.createQuery("SELECT * FROM post WHERE userID= :userid");
        query.setParameter("userID", userID);
        List<Post> posts = query.getResultList();
        return posts;
    }

    @Override
    public List<Post> getAllUserAndFollowersPosts(int userID)
    {
        Query query = entityManager.createQuery("SELECT content FROM post P, follower F WHERE P.userID=F.followerId OR P.userID=:userID");
        List<Post> posts = query.getResultList();
        query.setParameter("userID", userID);
        return posts;
    }

    @Override
    public List<Post> getEveryPost()
    {
        Query query = entityManager.createQuery("SELECT content FROM post");
        List<Post> posts = query.getResultList();
        return posts;
    }

    @Override
    public void createNewPost(int userID, String content)
    {
        String hql = "INSERT INTO pst (:userID,:content)" + "SELECT userID,content";
        Query query = entityManager.createQuery(hql);
        query.setParameter("userID", userID);
        query.setParameter("content", content);
        query.executeUpdate();
    }
}
