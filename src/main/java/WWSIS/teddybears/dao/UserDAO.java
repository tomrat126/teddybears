package WWSIS.teddybears.dao;

import WWSIS.teddybears.model.User;

public interface UserDAO {

	public User getUserByLogin(String login);
	
	public void addNewUser(User user);
}
