package binzet.repository;

import binzet.model.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    void delete(int id);
    Product getById(int id);
    List<Product> findAll();
    void update(Product product);
}
