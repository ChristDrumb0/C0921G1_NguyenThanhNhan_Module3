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

    //thục hành 13 1
    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;


    //thực hành 13 2
    void addUserTransaction(User user, int[] permision);

    //thục hành 13 3
    public void insertUpdateWithoutTransaction();

    //thục hành 13 4
    public void insertUpdateUseTransaction();

    //bai tap 13 1
    void updateUserStore(User user) throws SQLException;
    List<User> viewUserStore() throws SQLException;
    void deleteUserStore(int id) throws SQLException;


}
