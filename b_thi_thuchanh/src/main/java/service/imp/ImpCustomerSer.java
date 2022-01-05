package service.imp;

import bean.Customer;
import service.CustomerSer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ImpCustomerSer implements CustomerSer {
    @Override
    public List<Customer> searchByName(String name) {
        return null;
    }

    @Override
    public List<Customer> listCustomer() {
        return null;
    }

    @Override
    public Map<String, String> addCustomer(Customer customer) throws SQLException {
        return null;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return false;
    }

    @Override
    public Map<String, String> editCustomer(Customer customer) throws SQLException {
        return null;
    }

    @Override
    public Customer findCustomerById(int id) {
        return null;
    }
}
