package service;

import bean.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CustomerSer {
    public List<Customer> searchByName(String name);

    public List<Customer> listCustomer();

    public Map<String,String> addCustomer(Customer customer) throws SQLException;
    public boolean deleteCustomer(int id) throws SQLException;
    public Map<String,String> editCustomer(Customer customer) throws SQLException;

    public Customer findCustomerById(int id);
}
