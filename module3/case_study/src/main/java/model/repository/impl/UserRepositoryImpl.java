package model.repository.impl;

import model.repository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {
    public static final String SQL_FIND_USER = "select * from user where username = ? and password = ?";
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public boolean isLog(String username,String password) {
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SQL_FIND_USER);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
