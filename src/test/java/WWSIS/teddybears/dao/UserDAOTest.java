package WWSIS.teddybears.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import WWSIS.teddybears.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
@Transactional
@Rollback(true)
public class UserDAOTest {

	private static final String MOCK_FIRSTNAME = "MOCK_FIRSTNAME";
	private static final String MOCK_LASTNAME = "MOCK_LASTNAME";
	private static final String MOCK_NICKNAME = "MOCK_NICKNAME";
	private static final String MOCK_PASSWORD = "MOCK_PASSWORD";
	private static final String EMPTY_STRING = "";
	private static final String BLANK_STRING = "    ";

	@Autowired
	UserDAO userDao;

	@Before
	public void initialize() {
		userDao = new UserDAOImpl();
	}

	private User prepareMockUser() {
		User mockUser = new User();
		mockUser.setFirstName(MOCK_FIRSTNAME);
		mockUser.setLastName(MOCK_LASTNAME);
		mockUser.setNickName(MOCK_NICKNAME);
		mockUser.setPassword(MOCK_PASSWORD);
		return mockUser;
	}
	
	@Test
	public void shouldFindUser() {
		User mockUser = prepareMockUser();
		userDao.addNewUser(mockUser);
		User user = userDao.getUserByLogin(MOCK_NICKNAME);
		assertEquals(mockUser, user);
	}
	
	@Test
	public void shouldNotFindUserWithNullNickname() {
		User user = userDao.getUserByLogin(null);
		assertNull(user);
	}
	
	@Test
	public void shouldNotFindUserWithEmptyNickname() {
		String nickname = EMPTY_STRING;
		User user = userDao.getUserByLogin(nickname);
		assertNull(user);
	}
	
	public void shouldNotFindUserWithBlankNickname() {
		String nickname = BLANK_STRING;
		User user = userDao.getUserByLogin(nickname);
		assertNull(user);
	}


}
