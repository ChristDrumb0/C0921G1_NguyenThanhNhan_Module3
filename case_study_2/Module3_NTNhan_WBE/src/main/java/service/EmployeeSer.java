package service;

import model.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeSer {

    public List<Employee> searchByName(String something);

    public List<Employee> listEmployee();

    public Map<String,String> addEmployee(Employee employee) throws SQLException;
    public boolean deleteEmployee(int id) throws SQLException;
    public Map<String,String> editEmployee(Employee employee) throws SQLException;

    public Employee findEmployeeById(int id);

}
