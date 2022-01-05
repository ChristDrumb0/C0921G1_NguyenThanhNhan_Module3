package controller;

import model.*;
import reponsitory.CustomerRepo;
import reponsitory.imlement.ImpCustomerRepo;
import service.CustomerSer;
import service.implement.ImpCustomerSer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    CustomerSer customerSer = new ImpCustomerSer();
    CustomerRepo customerRepo = new ImpCustomerRepo();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            default:

                break;
        }
    } //doPost

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = new Customer();
//      name,dob,gender,personalId,phone,email,address,customerType
        customer.setName(request.getParameter("name"));
        customer.setDob(request.getParameter("dob"));
        customer.setGender( request.getParameter("gender"));
        customer.setCmnd(request.getParameter("personalId"));
        customer.setPhone( request.getParameter("phone"));
        customer.setEmail( request.getParameter("email"));
        customer.setAddress( request.getParameter("address"));
        customer.setType( request.getParameter("customerType"));
        try {
            Map<String,String> messageMap = customerSer.addCustomer(customer);
            if (!messageMap.isEmpty()) {
//                request.setAttribute("msgName", messageMap.get("namemsg"));
                request.setAttribute("msgPersonalId", messageMap.get("personalIdmsg"));
                request.setAttribute("msgPhone", messageMap.get("phonemsg"));
                request.setAttribute("msgDate", messageMap.get("datemsg"));
                request.setAttribute("msgEmail", messageMap.get("emailmsg"));
                request.setAttribute("customer", customer);
                showCustomerCreate(request, response);
            } else {
                response.sendRedirect("/customer");
            }
        } catch (SQLException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = new Customer();
//      name,dob,gender,personalId,phone,email,address,customerType
        customer.setId(Integer.parseInt(request.getParameter("id")));
        customer.setName(request.getParameter("name"));
        customer.setDob(request.getParameter("dob"));
        customer.setGender( request.getParameter("gender"));
        customer.setCmnd(request.getParameter("personalId"));
        customer.setPhone( request.getParameter("phone"));
        customer.setEmail( request.getParameter("email"));
        customer.setAddress( request.getParameter("address"));
        customer.setType( request.getParameter("customerType"));
        try {
            Map<String,String> messageMap = customerSer.editCustomer(customer);
            if (!messageMap.isEmpty()) {
//                request.setAttribute("msgName", messageMap.get("namemsg"));
                request.setAttribute("msgPersonalId", messageMap.get("personalIdmsg"));
                request.setAttribute("msgPhone", messageMap.get("phonemsg"));
                request.setAttribute("msgDate", messageMap.get("datemsg"));
                request.setAttribute("msgEmail", messageMap.get("emailmsg"));
                request.setAttribute("customer", customer);
                showCustomerEdit(request, response);
            } else {
                response.sendRedirect("/customer");
            }
        } catch (SQLException | IOException | ServletException throwables) {
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
                    showCustomerCreate(request, response);
                    break;
                case "edit":
                    showCustomerEdit(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
                case "search":
                    searchCustomer(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);

        }
    } //do Get

    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Customer> listCustomer = customerSer.listCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Customer/listCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void showCustomerCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<CustomerType> customerTypes = customerRepo.selectCustomerType();
        request.setAttribute("getCustomerType", customerTypes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Customer/createCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerEdit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerSer.findCustomerById(id);
        List<CustomerType> customerType = customerRepo.selectCustomerType();
        request.setAttribute("getCustomerType", customerType);
        request.setAttribute("customer",existingCustomer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Customer/editCustomer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        customerSer.deleteCustomer(id);
        listCustomer(request, response);

    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String something = request.getParameter("search");
        List<Customer> listSearch = customerSer.searchByName(something);
        request.setAttribute("listCustomer", listSearch);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Customer/listCustomer.jsp");
        dispatcher.forward(request, response);
    }





}
