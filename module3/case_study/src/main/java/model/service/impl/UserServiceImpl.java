package model.service.impl;

import model.repository.UserRepository;
import model.repository.impl.UserRepositoryImpl;
import model.repository.impl.UserRepositoryImplAnother;
import model.service.UserService;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImplAnother();

    @Override
    public boolean isLog(String username,String password) {
        return userRepository.isLog(username,password);
    }
}
