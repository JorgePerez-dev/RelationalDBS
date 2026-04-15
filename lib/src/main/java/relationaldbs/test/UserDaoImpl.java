package relationaldbs.test;


import relationaldbs.user;
import relationaldbs.dao.UserDao;

public class UserDaoImpl {
	public static void main(String[] args) {
		//insert test
		UserDao userDao =  (UserDao) new UserDaoImpl();
		userDao.insert(new user("Jorge", "18", "jorge@email", "7463746373", "madrid", "españa", null, null, 0));
		
	}

}
