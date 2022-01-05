package repository.imp;

import bean.Customer;
import bean.CustomerType;
import repository.CustomerRepo;

import java.sql.SQLException;
import java.util.List;

public class ImpCustomerRepo implements CustomerRepo {
    @Override
    public List<Customer> searchByName(String something) {
        return null;
    }

    @Override
    public List<Customer> listCustomer() {
        return null;
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {

    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean editCustomer(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public List<CustomerType> selectCustomerType() {
        return null;
    }

    @Override
    public Customer findCustomerById(int id) {
        return null;
    }
}
