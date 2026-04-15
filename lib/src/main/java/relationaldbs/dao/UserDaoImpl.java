package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import relationaldbs.user;

public class UserDaoImpl implements UserDao {

    private final static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres";

    private static String username = "postgres";
    
    private static String password = "Admin";


	
	
	
	@Override
	public boolean insert(user user) {
		// insert sql
		String insertSQL = 
			"Insert into users(name, password, isVIP, balance" + "values(?,?,?,?)";
		
		/**
		 * create an object of connection to establish
		 * a network connection with the databse used in
		 * our program
		 */
		
		
		
		
		
		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
				PreparedStatement pStatement = conn.prepareStatement(insertSQL)) {
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			PreparedStatement ps =
					
			ps.setString(1, user.getName());
					
			
			
		}
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
