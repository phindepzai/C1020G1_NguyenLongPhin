package binzet.repository.impl;

import binzet.entity.Employee;
import binzet.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public void save(Employee employee) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if (employee.getId() == null){
            BaseRepository.entityManager.persist(employee);
        } else {
            BaseRepository.entityManager.merge(employee);
        }
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        entityTransaction.commit();
    }

    @Override
    public void deleteAll() {
        for (Employee e:findAll()) {
            delete(e.getId());
        }
    }

    @Override
    public List<Employee> findAll() {
        Query query = BaseRepository.entityManager.createNativeQuery("select * from employee",Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return BaseRepository.entityManager.find(Employee.class,id);
    }
}
