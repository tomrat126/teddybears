package WWSIS.teddybears.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import WWSIS.teddybears.model.User;

@Transactional
public class UserDAOImpl implements UserDAO {

	private static final String USERS_TABLE = "users";
	private static final String USERS_TABLE_NICK_NAME_FIELD = "nick_name";

	private static final String NICK_NAME_QUERY_PROPERTY = "nickName";

	private static final int FIRST_LIST_INDEX = 0;

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByLogin(String login) {
		String qlString = "SELECT u FROM " + USERS_TABLE + " u WHERE LOWER(u." + USERS_TABLE_NICK_NAME_FIELD
				+ ") = LOWER(:" + NICK_NAME_QUERY_PROPERTY + ")";
		Query query = entityManager.createQuery(qlString);
		query.setParameter(NICK_NAME_QUERY_PROPERTY, login);
		List<User> users = query.getResultList();

		if (notSingleUserFound(users)) {
			return null;
		}

		return users.get(FIRST_LIST_INDEX);
	}

	private boolean notSingleUserFound(List<User> users) {
		return users == null || users.isEmpty() || users.size() > 1;
	}

	@Override
	public void addNewUser(User user) {
		entityManager.persist(user);
	}

}
