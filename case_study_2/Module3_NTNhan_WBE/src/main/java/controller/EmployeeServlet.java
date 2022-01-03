package controller;

import model.*;
import model.Employee;
import reponsitory.EmployeeRepo;
import reponsitory.imlement.impEmployeeRepo;
import service.EmployeeSer;
import service.implement.impEmployeeSer;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeSer employeeSer = new impEmployeeSer();
    EmployeeRepo employeeRepo = new impEmployeeRepo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
            default:

                break;
        }
    }//do Post
    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
//        String msg = null;
//        boolean flag = false;
        Employee employee = new Employee();
//      name,dob,gender,personalId,salary,phone,email,address,position,education,division,username
        employee.setName(request.getParameter("name"));
        employee.setDob(request.getParameter("dob"));
        employee.setGender( request.getParameter("gender"));
        employee.setCmnd(request.getParameter("personalId"));
//        if (Validate.regexIdCard(request.getParameter("personalId"))) {
//            msg = "Id Card not match";
//            flag = true;
//        };
        employee.setSalary( Double.parseDouble(request.getParameter("salary")));
        employee.setPhone( request.getParameter("phone"));
        employee.setEmail( request.getParameter("email"));
        employee.setAddress( request.getParameter("address"));
        employee.setPosition( request.getParameter("position"));
        employee.setEducation( request.getParameter("education"));
        employee.setDivision( request.getParameter("division"));
        employee.setUsername( request.getParameter("username"));

        try {
//            if (flag) {
////                request.setAttribute("msgIdCard", msg);
//                request.setAttribute("employee", employee);
//                showEmployeeCreate(request, response);
//            } else {
                employeeSer.addEmployee(employee);
                response.sendRedirect("/employee");
//            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        Employee employee = new Employee();
//      name,dob,gender,personalId,salary,phone,email,address,position,education,division,username
        employee.setId(Integer.parseInt(request.getParameter("id")));
        employee.setName(request.getParameter("name"));
        employee.setDob(request.getParameter("dob"));
        employee.setGender( request.getParameter("gender"));
        employee.setCmnd(request.getParameter("personalId"));
//        if (Validate.regexIdCard(request.getParameter("personalId"))) {
//            msg = "Id Card not match";
//            flag = true;
//        };
        employee.setSalary( Double.parseDouble(request.getParameter("salary")));
        employee.setPhone( request.getParameter("phone"));
        employee.setEmail( request.getParameter("email"));
        employee.setAddress( request.getParameter("address"));
        employee.setPosition( request.getParameter("position"));
        employee.setEducation( request.getParameter("education"));
        employee.setDivision( request.getParameter("division"));
        employee.setUsername( request.getParameter("username"));

        try {
//            if (flag) {
////                request.setAttribute("msgIdCard", msg);
//                request.setAttribute("employee", employee);
//                showEmployeeCreate(request, response);
//            } else {
            employeeSer.editEmployee(employee);
            response.sendRedirect("/employee");
//            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showEmployeeCreate(request, response);
                    break;
                case "edit":
                    showEmployeeEdit(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                case "search":
                    searchEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);

        }

    }// do get

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Employee> listEmployee = employeeSer.listEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String something = request.getParameter("search");
        List<Employee> listSearch = employeeSer.searchByName(something.toLowerCase());
        request.setAttribute("listEmployee", listSearch);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEmployeeCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Position> positionList = employeeRepo.selectPosition();
        List<Education> educationList = employeeRepo.selectEducation();
        List<Division> divisionList = employeeRepo.selectDivision();
        request.setAttribute("getPosition", positionList);
        request.setAttribute("getEducation", educationList);
        request.setAttribute("getDivision", divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    private void showEmployeeEdit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeSer.findEmployeeById(id);
        List<Position> positionList = employeeRepo.selectPosition();
        List<Education> educationList = employeeRepo.selectEducation();
        List<Division> divisionList = employeeRepo.selectDivision();
        request.setAttribute("getPosition", positionList);
        request.setAttribute("getEducation", educationList);
        request.setAttribute("getDivision", divisionList);
        request.setAttribute("employee",existingEmployee);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Employee/edit.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        employeeSer.deleteEmployee(id);
        listEmployee(request, response);
//        List<User> listUser = userService.selectAllUsers();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user/List.jsp");
//        dispatcher.forward(request, response);
    }






















































} //tổng