package springguide.securing.webapps.usersecurity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class UserInfoDAO implements IUserInfoDAO {

	private EntityManager entityManager;
	public UserInfo getActiveUser(String userName) {
		UserInfo activeUserInfo = new UserInfo();
		String active = "YES";
		List<?> list = entityManager.createQuery("SELECT u FROM user_security u WHERE username=? and active=?")
				.setParameter(1, userName).setParameter(2, active).getResultList();
		if(!list.isEmpty()) {
			activeUserInfo = (UserInfo)list.get(0);
		}
		System.out.println("activeUserInfo: " + activeUserInfo);
		return activeUserInfo;
	}
} 