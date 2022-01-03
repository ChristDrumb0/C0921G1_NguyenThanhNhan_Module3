package service;

import model.Customer;


import java.sql.SQLException;
import java.util.List;

public interface CustomerSer {

    public List<Customer> searchByName(String name);

    public List<Customer> listCustomer();

    public void addCustomer(Customer customer) throws SQLException;
    public boolean deleteCustomer(int id) throws SQLException;
    public boolean editCustomer(Customer customer) throws SQLException;

    public Customer findCustomerById(int id);
}
