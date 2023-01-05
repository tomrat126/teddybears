package WWSIS.teddybears.dao;

import WWSIS.teddybears.model.Follower;
import WWSIS.teddybears.model.User;

public class FollowerDAOImpl implements FollowerDao {
    @Override
    public void add(int followedId, int followerId) {
        // TODO
    }

    @Override
    public void remove(int followedId, int followerId) {
        // TODO
    }

    @Override
    public Follower getByFollowedId(int followedId) {
        return new Follower();
    }
}
