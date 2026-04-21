package relationaldbs.dao;

import relationaldbs.Car;
import relationaldbs.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean insert(Car product) {
		try {
		    Connection conn = DBConnection.getConnection();
		    String sql = "INSERT INTO car (marca, modelo, precio, disponible) VALUES (?, ?, ?, ?)";
		    PreparedStatement stmt = conn.prepareStatement(sql);

		    stmt.setString(1, product.getMarca());
		    stmt.setString(2, product.getModelo());
		    stmt.setDouble(3, product.getPrecio());
		    stmt.setBoolean(4, product.isDisponible());

		    stmt.executeUpdate();
		    return true;

		} catch (Exception e) {
		    e.printStackTrace();
		    return false;
		}
		// TODO Auto-generated method stub
	}
	

	@Override
	public boolean delete(Long id) {
		try {
		    Connection conn = DBConnection.getConnection();
		    String sql = "DELETE FROM car WHERE id = ?";
		    PreparedStatement stmt = conn.prepareStatement(sql);

		    stmt.setLong(1, id);
		    stmt.executeUpdate();

		    return true;

		} catch (Exception e) {
		    e.printStackTrace();
		    return false;
		}
		// TODO Auto-generated method stub
	}
	

	@Override
	public void update(Car car) {
		try {
		    Connection conn = DBConnection.getConnection();
		    String sql = "UPDATE car SET marca=?, modelo=?, precio=?, disponible=? WHERE id=?";
		    PreparedStatement stmt = conn.prepareStatement(sql);

		    stmt.setString(1, car.getMarca());
		    stmt.setString(2, car.getModelo());
		    stmt.setDouble(3, car.getPrecio());
		    stmt.setBoolean(4, car.isDisponible());

		    stmt.setLong(5, 1); 

		    stmt.executeUpdate();

		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}

	@Override
	public Car find(Long id) {
		try {
		    Connection conn = DBConnection.getConnection();
		    String sql = "SELECT * FROM car WHERE id = ?";
		    PreparedStatement stmt = conn.prepareStatement(sql);

		    stmt.setLong(1, id);
		    ResultSet rs = stmt.executeQuery();

		    if (rs.next()) {
		        return new Car(
		                rs.getString("marca"),
		                rs.getString("modelo"),
		                rs.getDouble("precio")
		        );
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		}
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public List<Car> findAll() {
		List<Car> lista = new ArrayList<>();

		try {
		    Connection conn = DBConnection.getConnection();
		    String sql = "SELECT * FROM car";
		    PreparedStatement stmt = conn.prepareStatement(sql);

		    ResultSet rs = stmt.executeQuery();

		    while (rs.next()) {
		        Car car = new Car(
		                rs.getString("marca"),
		                rs.getString("modelo"),
		                rs.getDouble("precio")
		        );
		        lista.add(car);
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		}

		return lista;
		// TODO Auto-generated method stub
		
	}

  }