package service;


import model.User;
import repositories.ImpRepository;
import repositories.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpService implements Service {
    Repository repo =  new ImpRepository();

    public ImpService() {
    }

    @Override
    public void insertUser(User user) throws SQLException {
        repo.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return repo.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return repo.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return repo.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return repo.updateUser(user);
    }

}
