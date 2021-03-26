package binzet.repository.impl;

import binzet.model.Product;
import binzet.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    public void update(Product product){
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(getById(id));
        entityTransaction.commit();
    }

    @Override
    public Product getById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        Query typedQuery =
                BaseRepository.entityManager.createNativeQuery("select * from product", Product.class);
        return typedQuery.getResultList();
    }
}
