package repositories;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface Repository {

    public List<User>searchByCountry(String something);

    public List<User> sortByName(String sort);

    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;


    //bai tap 13 1
    void updateUserStore(User user) throws SQLException;
    List<User> viewUserStore() throws SQLException;
    void deleteUserStore(int id) throws SQLException;

    //thuc hành ss13 1
    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

    //thuc hành ss13 2
    void addUserTransaction(User user, int[] permision);

    //thực hành ss13 3
    public void insertUpdateWithoutTransaction();

    //thực hành ss13 4
    public void insertUpdateUseTransaction();






























}
