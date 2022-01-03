package reponsitory.imlement;

import model.*;
import reponsitory.EmployeeRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class impEmployeeRepo implements EmployeeRepo {
//    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy_2";
//    private String jdbcUsername = "root";
//    private String jdbcPassword = "NhanhoMn@ylaso1";
//    private ConnectionSQL connections;
    private static final String SELECT_ALL_EMPLOYEE = " select e.id,e.`name`,e.dob,e.gender,e.personal_id,e.salary,e.phone,e.email,e.address, \n " +
            " posi.`name` posiname,edu.`name` eduname,divi.`name` diviname,e.username,e.is_delete\n " +
            " from employee e\n" +
            " left join position posi on posi.id = e.position_id \n " +
            " left join education edu on edu.id = e.education_id \n " +
            "  left join division divi on divi.id = e.division_id ";
    private static final String INSERT_EMPLOYEE_SQL = " INSERT INTO employee (`name`,dob,gender,personal_id,salary,phone,email,address,position_id,education_id,division_id,username) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_EMPLOYEE_BY_ID = "select e.id,e.`name`,e.dob,e.gender,e.personal_id,e.salary,e.phone,e.email,e.address, posi.`name` posiname,edu.`name` eduname,divi.`name` diviname,e.username from employee e left join position posi on posi.id = e.position_id left join education edu on edu.id = e.education_id left join division divi on divi.id = e.division_id where e.id = ?; ";
    private static final String DELETE_USERS_SQL = "update employee set is_delete = ? where id = ?;";
    private static final String UPDATE_USERS_SQL = " update employee set `name`= ?,dob=? ,gender=?,personal_id=?,salary=?,phone=?,email=?,address=?,position_id=?,education_id=?,division_id=?,username= ? where id = ?; ";
    private static final String SELECT_POSITION = "select * FROM position";
    private static final String SELECT_EDUCATION = "select * FROM education";
    private static final String SELECT_DIVISION = "select * FROM division";
//    private static final String SEARCH_USERS_SQL = "select id,name,email,country from users where country like ?;";


//    protected ConnectionSQL getConnection() {
//        ConnectionSQL connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }

    @Override
    public List<Employee> searchByName(String something) {

        List<Employee> employees = listEmployee();
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().toLowerCase().contains(something)) {
                result.add(employee);
            }
        }
        return result;
    }

    // turn gender into String
    private String getGender(int g) {

        if (g == 1) {
            return "female";
        } else {
            return "male";
        }
    }

    @Override
    public List<Employee> listEmployee() {
        List<Employee> employees = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Employee emp = new Employee();
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String dob = rs.getString("dob");
//                String gender = getGender(rs.getInt("gender")) ;
//                String cmnd = rs.getString("personal_id");
//                double salary = rs.getDouble("salary");
//                String phone = rs.getString("phone");
//                String email = rs.getString("email");
//                String address = rs.getString("address");
//                String position = rs.getString("posiname");
//                String education = rs.getString("eduname");
//                String division = rs.getString("diviname");
//                String username = rs.getString("username");
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDob(rs.getString("dob"));
                emp.setGender(getGender(rs.getInt("gender")));
                emp.setCmnd(rs.getString("personal_id"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setPhone(rs.getString("phone"));
                emp.setEmail(rs.getString("email"));
                emp.setAddress(rs.getString("address"));
                emp.setPosition(rs.getString("posiname"));
                emp.setEducation(rs.getString("eduname"));
                emp.setDivision(rs.getString("diviname"));
                emp.setUsername(rs.getString("username"));

//                employees.add(new Employee(id, name, dob, gender,cmnd,salary,phone,email,address,position,education,division,username));
                if (rs.getByte("is_delete")!=1){
                    employees.add(emp);
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }

        return employees;
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        Connection connection = new ConnectionSQL().getConnection();
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDob());
            preparedStatement.setInt(3, Integer.parseInt(employee.getGender()));
            preparedStatement.setString(4, employee.getCmnd());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setString(6, employee.getPhone());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setInt(9, Integer.parseInt(employee.getPosition()));
            preparedStatement.setInt(10, Integer.parseInt(employee.getEducation()));
            preparedStatement.setInt(11, Integer.parseInt(employee.getDivision()));
            preparedStatement.setString(12, employee.getUsername());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
            printSQLException(ignored);

        } finally {
            ConnectionSQL.close();
        }

    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = new ConnectionSQL().getConnection();
        try ( PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {

            statement.setBoolean(1, true);
            statement.setInt(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return rowUpdated;
    }

    @Override
    public boolean editEmployee(Employee employee) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = new ConnectionSQL().getConnection();
        try ( PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
// set `name`= ?,dob=? ,gender=?,personal_id=?,salary=?,phone=?,email=?,address=?,position_id=?,education_id=?,division_id=?,username= ? where id = ?;
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDob());
            statement.setBoolean(3, Boolean.parseBoolean(employee.getGender()));
            statement.setString(4, employee.getCmnd());
            statement.setDouble(5, employee.getSalary());
            statement.setString(6, employee.getPhone());
            statement.setString(7, employee.getEmail());
            statement.setString(8, employee.getAddress());
            statement.setInt(9,Integer.parseInt(employee.getPosition()));
            statement.setInt(10,Integer.parseInt(employee.getEducation()));
            statement.setInt(11,Integer.parseInt(employee.getDivision()));
            statement.setString(12, employee.getUsername());
            statement.setInt(13, employee.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    // get employee by id
    @Override
    public Employee findEmployeeById(int id) {
        Employee emp =null;
        Connection connection = new ConnectionSQL().getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                emp = new Employee();
                emp.setId(id);
                emp.setName(rs.getString("name"));
                emp.setDob(rs.getString("dob"));
                emp.setGender(getGender(rs.getInt("gender")));
                emp.setCmnd(rs.getString("personal_id"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setPhone(rs.getString("phone"));
                emp.setEmail(rs.getString("email"));
                emp.setAddress(rs.getString("address"));
                emp.setPosition(rs.getString("posiname"));
                emp.setEducation(rs.getString("eduname"));
                emp.setDivision(rs.getString("diviname"));
                emp.setUsername(rs.getString("username"));
            }


        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }

        return emp;
    }

    // get employee position
    public List<Position> selectPosition() {
        List<Position> educationList = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                educationList.add(new Position(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return educationList;
    }

    // get employee Education
    public List<Education> selectEducation() {
        List<Education> educationList = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EDUCATION)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                educationList.add(new Education(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return educationList;
    }


    // get employee division
    public List<Division> selectDivision() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIVISION)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                divisionList.add(new Division(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            ConnectionSQL.close();
        }
        return divisionList;
    }



    public static void main(String[] args) {
        impEmployeeRepo rep = new impEmployeeRepo();
        System.out.println(rep.findEmployeeById(1).toString());
//        for (Employee e : rep.findEmployeeById(18)) {
//            System.out.println(e.toString());
//        }

    }
}
