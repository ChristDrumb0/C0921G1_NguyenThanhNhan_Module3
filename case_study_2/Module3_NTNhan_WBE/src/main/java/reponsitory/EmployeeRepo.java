package reponsitory;

import model.*;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepo {

    public List<Employee> searchByName(String something);

    public List<Employee> listEmployee();

    public void addEmployee(Employee employee) throws SQLException;
    public boolean deleteEmployee(int id) throws SQLException;
    public boolean editEmployee(Employee employee) throws SQLException;
    public List<Position> selectPosition();
    public List<Division> selectDivision();
    public List<Education> selectEducation();
    public Employee findEmployeeById(int id);
}
