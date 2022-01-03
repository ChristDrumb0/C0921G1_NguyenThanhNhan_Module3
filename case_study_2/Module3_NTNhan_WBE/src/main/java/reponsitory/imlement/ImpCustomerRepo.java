package reponsitory.imlement;

import model.*;
import model.Customer;
import reponsitory.CustomerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpCustomerRepo implements CustomerRepo {

    private static final String SELECT_ALL_CUSTOMER = " select c.id,c.`name`,c.dob,c.gender,c.personal_id,c.phone,c.email,c.address,ct.`name` ctname,c.is_delete " +
            " from customer c " +
            " left join customer_type ct on ct.id = c.customer_type_id; ";
    private static final String INSERT_CUSTOMER_SQL = " INSERT INTO customer (`name`,dob,gender,personal_id,phone,email,address,customer_type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_CUSTOMER_BY_ID = " select c.id,c.`name`,c.dob,c.gender,c.personal_id,c.phone,c.email,c.address,ct.`name` ctname from customer c left join customer_type ct on ct.id = c.customer_type_id where c.id = ?; ";
    private static final String DELETE_CUSTOMER_SQL = "update customer set is_delete = ? where id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = " update customer set `name`= ?,dob=? ,gender=?,personal_id=?,phone=?,email=?,address=?,customer_type_id=? where id = ?; ";
    private static final String SELECT_CUSTOMER_TYPE = "select * FROM customer_type";



    @Override
    public List<Customer> searchByName(String name) {
        return null;
    }

    private String getGender(int g) {

        if (g == 1) {
            return "female";
        } else {
            return "male";
        }
    }

    @Override
    public List<Customer> listCustomer() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (

                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
//               select c.id,c.`name`,c.dob,c.gender,c.personal_id,c.phone,c.email,c.address,ct.`name` ctname
                Customer cus = new Customer();
                cus.setId(rs.getInt("id"));
                cus.setName(rs.getString("name"));
                cus.setDob(rs.getString("dob"));
                cus.setGender(getGender(rs.getInt("gender")));
                cus.setCmnd(rs.getString("personal_id"));
                cus.setPhone(rs.getString("phone"));
                cus.setEmail(rs.getString("email"));
                cus.setAddress(rs.getString("address"));
                cus.setType(rs.getString("ctname"));


                if (rs.getByte("is_delete")!=1){
                    customers.add(cus);
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }

        return customers;
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getDob());
            preparedStatement.setInt(3, Integer.parseInt(customer.getGender()));
            preparedStatement.setString(4, customer.getCmnd());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, Integer.parseInt(customer.getType()));

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
            printSQLException(ignored);

        } finally {
            ConnectionSQL.close();
        }
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowUpdated;
        Connection connection = new ConnectionSQL().getConnection();
        try ( PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {

            statement.setBoolean(1, true);
            statement.setInt(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean editCustomer(Customer customer) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = new ConnectionSQL().getConnection();
        try ( PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
// set `name`= ?,dob=? ,gender=?,personal_id=?,phone=?,email=?,address=?,customer_type_id=? where id = ?;
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getDob());
            statement.setBoolean(3, Boolean.parseBoolean(customer.getGender()));
            statement.setString(4, customer.getCmnd());
            statement.setString(5, customer.getPhone());
            statement.setString(6, customer.getEmail());
            statement.setString(7, customer.getAddress());
            statement.setInt(8,Integer.parseInt(customer.getType()));
            statement.setInt(9, customer.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return rowUpdated;
    }

    @Override
    public List<CustomerType> selectCustomerType() {
        List<CustomerType> customerType = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                customerType.add(new CustomerType(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return customerType;
    }

    @Override
    public Customer findCustomerById(int id) {
        Customer cus =null;
        Connection connection = new ConnectionSQL().getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                cus = new Customer();
                cus.setId(id);
                cus.setName(rs.getString("name"));
                cus.setDob(rs.getString("dob"));
                cus.setGender(getGender(rs.getInt("gender")));
                cus.setCmnd(rs.getString("personal_id"));
                cus.setPhone(rs.getString("phone"));
                cus.setEmail(rs.getString("email"));
                cus.setAddress(rs.getString("address"));
                cus.setType(rs.getString("ctname"));

            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }

        return cus;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    public static void main(String[] args) {
        ImpCustomerRepo rep = new ImpCustomerRepo();
        System.out.println(rep.findCustomerById(1).toString());
//        for (Customer e : rep.findCustomerById(18)) {
//            System.out.println(e.toString());
//        }

    }
}
