package repository;

import bean.Customer;
import bean.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepo {

    public List<Customer> searchByName(String something);

    public List<Customer> listCustomer();

    public void addCustomer(Customer customer) throws SQLException;
    public boolean deleteCustomer(int id) throws SQLException;
    public boolean editCustomer(Customer customer) throws SQLException;
    public List<CustomerType> selectCustomerType();
    public Customer findCustomerById(int id);

}
