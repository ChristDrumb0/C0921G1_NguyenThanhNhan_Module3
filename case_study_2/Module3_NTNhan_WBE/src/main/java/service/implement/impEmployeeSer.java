package service.implement;

import model.Employee;
import reponsitory.EmployeeRepo;
import reponsitory.imlement.impEmployeeRepo;
import service.EmployeeSer;

import java.sql.SQLException;
import java.util.List;

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
    public void addEmployee(Employee employee) throws SQLException {
        repo.addEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return repo.deleteEmployee(id);
    }

    @Override
    public boolean editEmployee(Employee employee) throws SQLException {
        return repo.editEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return repo.findEmployeeById(id);
    }
}
