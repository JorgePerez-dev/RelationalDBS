package relationaldbs.dao;


import java.util.List;

import relationaldbs.user;

public interface UserDao {

	/**
	 * inset an user object to database
	 * 
	 * @param user
	 * @return true if inserted succesfully, otherwise false
	 */

	public boolean insert(user user);

	/**
	 * delete an user by id
	 * 
	 * @param id
	 * @return
	 */

	public boolean delete(Long id);

	
	public void update(user user); 
	
	/**
	 * find an user by his id
	 * @param id
	 * @return
	 */
	
	
	public user find(Long id); 
		
	
	public List<user> findall();
		
	}
		

