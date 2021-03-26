package repository;

import bean.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    void delete(Integer id);
    User findById(Integer id);
    List<User> findAll();
    List<User> findByCountry(String country);
}
