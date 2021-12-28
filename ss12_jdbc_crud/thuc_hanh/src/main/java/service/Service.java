package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface Service {

    public List<User> searchByCountry(String something);

    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public List<User> sortByName(String sortType);

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;
}
