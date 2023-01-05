package WWSIS.teddybears.dao;

import WWSIS.teddybears.model.Follower;

public interface FollowerDao {
    void add(int followedId, int followerId);

    void remove(int followedId, int followerId);

    Follower getByFollowedId(int followedId);
}
