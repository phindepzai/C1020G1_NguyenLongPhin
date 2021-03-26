package service.impl;

import bean.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;
import service.sort.SortByName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll(int page) {
        List<User> list = new ArrayList<>();
        int start = (page - 1) * 5;
        int end;
        List<User> userRepositoryAll = userRepository.findAll();
        if (page * 5 > userRepositoryAll.size()){
            end = userRepositoryAll.size();
        } else {
            end = page * 5;
        }
        for (int i = start; i < end; i++) {
            list.add(userRepositoryAll.get(i));
        }
        return list;
    }

    @Override
    public List<User> findByCountry(String country, int page) {
        List<User> list = new ArrayList<>();
        int start = (page - 1) * 5;
        int end;
        List<User> userRepositoryAll = userRepository.findByCountry(country);
        if (page * 5 > userRepositoryAll.size()){
            end = userRepositoryAll.size();
        } else {
            end = page * 5;
        }
        for (int i = start; i < end; i++) {
            list.add(userRepositoryAll.get(i));
        }
        return list;
    }

    @Override
    public List<User> sortByName(int page) {
        List<User> userList = userRepository.findAll();
        SortByName sortByName = new SortByName();
        Collections.sort(userList,sortByName);
        return userList;
    }

    @Override
    public int size(){
        return userRepository.findAll().size();
    }


    @Override
    public int numPage(){
        return ((size() - 1)/5) + 1;
    }
}
