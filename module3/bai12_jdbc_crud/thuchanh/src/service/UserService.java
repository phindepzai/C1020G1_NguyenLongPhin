package service;

import bean.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void delete(Integer id);
    User findById(Integer id);
    List<User> findAll(int page);
    List<User> findByCountry(String country,int page);
    List<User> sortByName(int page);
    int size();
}
