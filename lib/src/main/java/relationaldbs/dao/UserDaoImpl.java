package relationaldbs.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import relationaldbs.user;
import relationaldbs.DBConnection;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean insert(user user) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users (name, password, age, email, phone, address, city, country, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAge());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getCity());
            ps.setString(8, user.getCountry());
            ps.setDouble(9, user.getBalance());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM users WHERE id = ?"
            );

            ps.setLong(1, id);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void update(user user) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE users SET name=?, password=?, age=?, email=?, phone=?, address=?, city=?, country=?, balance=? WHERE id=?"
            );

            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAge());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getCity());
            ps.setString(8, user.getCountry());
            ps.setDouble(9, user.getBalance());
            ps.setNString(10, user.getAge()); // ⚠️ necesitas este campo

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public user find(Long id) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM users WHERE id = ?"
            );

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new user(
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("age"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("city"),
                    rs.getString("country"),
                    rs.getDouble("balance")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<user> findAll() {
        List<user> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM users"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new user(
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("age"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("city"),
                    rs.getString("country"),
                    rs.getDouble("balance")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

	@Override
	public List<user> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	
} 