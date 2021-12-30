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
    public List<User> searchByCountry(String something) {
        return repo.searchByCountry(something);
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
    public List<User> sortByName(String sortType) {
        return repo.sortByName(sortType);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return repo.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return repo.updateUser(user);
    }


    //thuc hanh 13 1
    @Override
    public User getUserById(int id) {
        return repo.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        repo.insertUserStore(user);
    }

    //thuc hanh 13 2
    public void addUserTransaction(User user, int[] permision){
        repo.addUserTransaction(user, permision);
    }


    //thục hành 13 3
    @Override
    public void insertUpdateWithoutTransaction() {
        repo.insertUpdateWithoutTransaction();
    }

    //thục hành 13 4
    @Override
    public void insertUpdateUseTransaction() {
        repo.insertUpdateUseTransaction();
    }

    //bai tap 13 1
    @Override
    public void updateUserStore(User user) throws SQLException {
        repo.updateUserStore(user);
    }

    @Override
    public List<User> viewUserStore() throws SQLException {
        return repo.viewUserStore();
    }

    @Override
    public void deleteUserStore(int id) throws SQLException {
        repo.deleteUserStore(id);
    }

}
