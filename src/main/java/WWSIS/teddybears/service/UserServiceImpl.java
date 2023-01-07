package WWSIS.teddybears.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WWSIS.teddybears.dao.UserDAO;
import WWSIS.teddybears.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO dao;

	@Override
	public User getUserByLogin(String login) {
		return dao.getUserByLogin(login);
	}

	@Override
	public void addNewUser(User user) {
		dao.addNewUser(user);
	}
}
