package service.implement;

import model.Employee;
import reponsitory.EmployeeRepo;
import reponsitory.imlement.impEmployeeRepo;
import service.EmployeeSer;
import validate.Validate;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class impEmployeeSer implements EmployeeSer {
    EmployeeRepo repo = new impEmployeeRepo();
    @Override
    public List<Employee> searchByName(String something) {
        return repo.searchByName(something);
    }

    @Override
    public List<Employee> listEmployee() {
        return repo.listEmployee();
    }

    @Override
    public Map<String,String> addEmployee(Employee employee) throws SQLException {

//        if(Validate.regexName(employee.getName())){
//            mesMap.put("namemsg","Invalid Name, capitalize the first letter");
//        }
        Map<String,String> mesMap = new HashMap<>();
        if(Validate.regexPersonalId(employee.getCmnd())){
            mesMap.put("personalIdmsg","Personal Id mush had 9 or 12 digit");
        }
        if(Validate.regexPhone(employee.getPhone())){
            mesMap.put("phonemsg","Phone must be: 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx");
        }
        if(Validate.regexEmail(employee.getEmail())){
            mesMap.put("emailmsg","Email is not valid");
        }
        if(Validate.regexDate(employee.getDob())){
            mesMap.put("datemsg","Date of Birth is not valid");
        }
        if(mesMap.isEmpty()){
            repo.addEmployee(employee);
        }

        return mesMap;

    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return repo.deleteEmployee(id);
    }

    @Override
    public Map<String,String> editEmployee(Employee employee) throws SQLException {
        Map<String,String> mesMap = new HashMap<>();
//
//        if(Validate.regexName(employee.getName())){
//            mesMap.put("namemsg","Invalid Name, capitalize the first letter");
//        }
        if(Validate.regexPersonalId(employee.getCmnd())){
            mesMap.put("personalIdmsg","Personal Id mush had 9 or 12 digit");
        }
        if(Validate.regexPhone(employee.getPhone())){
            mesMap.put("phonemsg","Phone must be: 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx");
        }
        if(Validate.regexEmail(employee.getEmail())){
            mesMap.put("emailmsg","Email is not valid");
        }
        if(Validate.regexDate(employee.getDob())){
            mesMap.put("datemsg","Date of Birth is not valid");
        }
        if(mesMap.isEmpty()){
            repo.editEmployee(employee);
        }

        return mesMap;
    }

    @Override
    public Employee findEmployeeById(int id) {
        return repo.findEmployeeById(id);
    }
}
