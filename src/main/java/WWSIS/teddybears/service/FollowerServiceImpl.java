package WWSIS.teddybears.service;

import WWSIS.teddybears.dao.FollowerDao;
import WWSIS.teddybears.model.Follower;

import java.util.List;

public class FollowerServiceImpl implements FollowerService {
    private FollowerDao followerDao;

    public FollowerServiceImpl(FollowerDao followerDao) {
        this.followerDao = followerDao;
    }

    @Override
    public List<Follower> getFollowersByUserId(int userId) {
        return null;
    }

    @Override
    public void follow(int followedUserId, int followerUserId) {
        followerDao.add(followedUserId, followerUserId);
    }

    @Override
    public void unfollow(int followedUserId, int followerUserId) {
        followerDao.remove(followedUserId, followerUserId);
    }
}
