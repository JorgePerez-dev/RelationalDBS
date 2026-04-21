package relationaldbs.test;

import relationaldbs.dao.UserDao;
import relationaldbs.dao.UserDaoImpl;
import relationaldbs.user;

public class userdaoTest {

    public static void main(String[] args) {

        UserDao dao = new UserDaoImpl();

        // 🔹 INSERTAR USUARIOS
        user u1 = new user(
                "Jorge", "1234", "18", "jorge@mail.com",
                "666666", "Calle 1", "Madrid", "España", 100
        );

        user u2 = new user(
                "Ana", "abcd", "25", "ana@mail.com",
                "777777", "Calle 2", "Sevilla", "España", 200
        );

        dao.insert(u1);
        dao.insert(u2);

        System.out.println("Usuarios insertados ");
        
        
        
        
        
        
        
       
    }
}