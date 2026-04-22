package relationaldbs.test;

import relationaldbs.dao.UserDao;
import relationaldbs.dao.UserDaoImpl;
import relationaldbs.user;
import relationaldbs.DBConnection;

public class userdaoTest {

    public static void main(String[] args) {
    	
    	DBConnection.createTable();

        UserDao dao = new UserDaoImpl();

        // 🔹 INSERTAR USUARIOS
        user u1 = new user(
        	    "Manolo", "1234", 18, "jorge@email.com",
        	    "666666", "calle 1", "Madrid", "España", 100
        	);

        	user u2 = new user(
        	    "manolo", "abcd", 25, "ana@email.com",
        	    "777777", "calle 2", "Sevilla", "España", 200
        	);

        dao.insert(u1);
        dao.insert(u2);

        System.out.println("Usuarios insertados ");
        
        
        dao.findall();
        
        
        
        
       
    }
}