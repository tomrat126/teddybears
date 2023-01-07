package WWSIS.teddybears.service;

import WWSIS.teddybears.model.User;

public interface UserService {
	
	public User getUserByLogin(String login);
	
	public void addNewUser(User user);
}
