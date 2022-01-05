package service.implement;

import model.Customer;
import reponsitory.CustomerRepo;
import reponsitory.imlement.ImpCustomerRepo;
import service.CustomerSer;
import validate.Validate;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String,String> addCustomer(Customer customer) throws SQLException {

        Map<String,String> mesMap = new HashMap<>();
        if(Validate.regexPersonalId(customer.getCmnd())){
            mesMap.put("personalIdmsg","Personal Id mush had 9 or 12 digit");
        }
        if(Validate.regexPhone(customer.getPhone())){
            mesMap.put("phonemsg","Phone must be: 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx");
        }
        if(Validate.regexEmail(customer.getEmail())){
            mesMap.put("emailmsg","Email is not valid");
        }
        if(Validate.regexDate(customer.getDob())){
            mesMap.put("datemsg","Date of Birth is not valid");
        }
        if(mesMap.isEmpty()){
            repo.addCustomer(customer);
        }

        return mesMap;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return repo.deleteCustomer(id);
    }

    @Override
    public Map<String,String> editCustomer(Customer customer) throws SQLException {
        Map<String,String> mesMap = new HashMap<>();
        if(Validate.regexPersonalId(customer.getCmnd())){
            mesMap.put("personalIdmsg","Personal Id mush had 9 or 12 digit");
        }
        if(Validate.regexPhone(customer.getPhone())){
            mesMap.put("phonemsg","Phone must be: 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx");
        }
        if(Validate.regexEmail(customer.getEmail())){
            mesMap.put("emailmsg","Email is not valid");
        }
        if(Validate.regexDate(customer.getDob())){
            mesMap.put("datemsg","Date of Birth is not valid");
        }
        if(mesMap.isEmpty()){
            repo.editCustomer(customer);
        }
        return mesMap;
    }

    @Override
    public Customer findCustomerById(int id) {
        return repo.findCustomerById(id);
    }
}
