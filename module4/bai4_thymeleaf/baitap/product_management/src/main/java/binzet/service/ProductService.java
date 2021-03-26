package binzet.service;

import binzet.model.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    void update(Product product);
    void delete(int id);
    List<Product> findAll();
    Product getById(int id);
}
