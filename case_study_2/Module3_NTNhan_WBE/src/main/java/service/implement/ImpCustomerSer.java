package service.implement;

import model.Customer;
import reponsitory.CustomerRepo;
import reponsitory.imlement.ImpCustomerRepo;
import service.CustomerSer;

import java.sql.SQLException;
import java.util.List;

public class ImpCustomerSer implements CustomerSer {

    CustomerRepo repo = new ImpCustomerRepo();

    @Override
    public List<Customer> searchByName(String name) {
        return repo.searchByName(name);
    }

    @Override
    public List<Customer> listCustomer() {
        return repo.listCustomer();
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        repo.addCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return repo.deleteCustomer(id);
    }

    @Override
    public boolean editCustomer(Customer customer) throws SQLException {
        return repo.editCustomer(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return repo.findCustomerById(id);
    }
}
