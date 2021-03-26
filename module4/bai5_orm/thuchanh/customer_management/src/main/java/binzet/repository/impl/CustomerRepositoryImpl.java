package binzet.repository.impl;

import binzet.model.Customer;
import binzet.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery =
                BaseRepository.entityManager.createQuery("select s from customer s", Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public Customer findOne(Long id) {
        return BaseRepository.entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(customer);
        entityTransaction.commit();
    }

    @Override
    public void save(List<Customer> customers) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        for (Customer cus:customers) {
            BaseRepository.entityManager.merge(cus);
        }
        entityTransaction.commit();
    }

    @Override
    public boolean exists(Long id) {
        return findOne(id) != null;
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        List<Customer> list = new ArrayList<>();
        for (long i:ids) {
            if (findOne(i) != null){
                list.add(findOne(i));
            }
        }
        return list;
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public void delete(Long id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findOne(id));
        entityTransaction.commit();
    }

    @Override
    public void delete(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(customer);
        entityTransaction.commit();
    }

    @Override
    public void delete(List<Customer> customers) {
        for (Customer customer:customers) {
            delete(customer);
        }
    }

    @Override
    public void deleteAll() {
        delete(findAll());
    }
}
