import relationaldbs.Car;

import java.util.List;

public interface ProductDao {

    /**
     * insert a product into database
     * @param product
     * @return true if inserted successfully, otherwise false
     */
    public boolean insert(Car product);

    /**
     * delete a product by id
     * @param id
     * @return true if deleted
     */
    public boolean delete(Long id);

    /**
     * update a product
     * @param product
     */
    public void update(Car car);

    /**
     * find a product by id
     * @param id
     * @return Product
     */
    public Car find(Long id);  

    /**
     * get all products
     * @return list of products
     */
    public List<Car> findAll();
}
