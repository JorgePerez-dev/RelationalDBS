package relationaldbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Admin";

    // 🔹 CONEXIÓN
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 🔹 CREAR TABLA
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "id SERIAL PRIMARY KEY, "
                + "name VARCHAR(100), "
                + "password VARCHAR(100), "
                + "age INTEGER, " // ✅ 
                + "email VARCHAR(100), "
                + "phone VARCHAR(50), "
                + "address VARCHAR(100), "
                + "city VARCHAR(100), "
                + "country VARCHAR(100), "
                + "balance NUMERIC"
                + ")";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 INSERT
    public static void insertUser(String name, String password, String email,
                                  String phone, String address, String city,
                                  String country, double balance) {

        String sql = "INSERT INTO users (name, password, age, email, phone, address, city, country, balance) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.setString(7, city);
            ps.setString(8, country);
            ps.setDouble(9, balance);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 SELECT TODOS
    public static void getUsers() {
        String sql = "SELECT * FROM users";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("name") + " - " +
                        rs.getString("email") + " - " +
                        rs.getDouble("balance")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 DELETE POR ID
    public static void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 MAIN DE PRUEBA
    public static void main(String[] args) {

        createTable();

        insertUser("Jorge", "1234", "jorge@mail.com",
                "666666", "Calle 1", "Madrid", "España", 100);

        insertUser("Ana", "abcd", "ana@mail.com",
                "777777", "Calle 2", "Sevilla", "España", 200);

        System.out.println("USUARIOS:");
        getUsers();

        deleteUser(1);

        System.out.println("DESPUÉS DE BORRAR:");
        getUsers();
    }
}