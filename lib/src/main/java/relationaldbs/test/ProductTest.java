package relationaldbs.test;

import relationaldbs.Car;
import relationaldbs.dao.ProductDao;
import relationaldbs.dao.ProductDaoImpl;

public class ProductTest {

    public static void main(String[] args) {

        ProductDao dao = new ProductDaoImpl();

        // 🔹 INSERT
        Car c1 = new Car("Toyota", "Corolla", 20000);
        Car c2 = new Car("BMW", "X5", 50000);

        dao.insert(c1);
        dao.insert(c2);

        System.out.println("Coches insertados");

        // 🔹 FIND ALL
        System.out.println("LISTA:");
        for (Car c : dao.findAll()) {
            System.out.println(c.getMarca() + " - " + c.getModelo() + " - " + c.getPrecio());
        }

        // 🔹 FIND
        System.out.println("BUSCAR ID 1:");
        Car encontrado = dao.find(1L);
        if (encontrado != null) {
            System.out.println(encontrado.getMarca());
        }

        // 🔹 DELETE
        dao.delete(1L);
        System.out.println("BORRADO");

        // 🔹 LISTA FINAL
        System.out.println("LISTA FINAL:");
        for (Car c : dao.findAll()) {
            System.out.println(c.getMarca() + " - " + c.getModelo());
        }
    }
}