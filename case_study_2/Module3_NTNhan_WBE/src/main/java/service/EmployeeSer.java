package service;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeSer {

    public List<Employee> searchByName(String something);

    public List<Employee> listEmployee();

    public void addEmployee(Employee employee) throws SQLException;
    public boolean deleteEmployee(int id) throws SQLException;
    public boolean editEmployee(Employee employee) throws SQLException;

    public Employee findEmployeeById(int id);

}
