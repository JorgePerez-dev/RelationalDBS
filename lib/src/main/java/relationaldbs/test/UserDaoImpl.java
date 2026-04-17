package relationaldbs.test;


import java.util.List;

import relationaldbs.user;
import relationaldbs.dao.UserDao;

public class UserDaoImpl implements UserDao {
	public static void main(String[] args) {
		//insert test
		UserDao userDao =  (UserDao) new UserDaoImpl();
		userDao.insert(new user("Jorge", "18", "jorge@email", "7463746373", "madrid", "españa", null, null, 0));
		
	}

	@Override
	public boolean insert(user user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(user user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public user find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<user> findall() {
		// TODO Auto-generated method stub
		return null;
	}

}
