package WWSIS.teddybears.dao;

import WWSIS.teddybears.model.Post;
import java.util.List;

public interface PostDAO {

    public List<Post> getAllUsersPosts(int userID);

    public List<Post> getAllUserAndFollowersPosts(int userID);

    public List<Post> getEveryPost();

    public void createNewPost(int userID, String content);
}
