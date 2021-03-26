package model.repository.impl;

import model.repository.UserRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepositoryImplAnother implements UserRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public boolean isLog(String username, String password) {
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            String sql = "select * from `user` where username = " + username + " and password = " + password;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
