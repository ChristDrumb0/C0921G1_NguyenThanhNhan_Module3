package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                createCustomer(request, response);
                break;
            case "edit":
//                updateCustomer(request, response);
                break;
            default:

                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

//        try {
            switch (action) {
                case "create":
//                    showCustomerCreate(request, response);
                    break;
                case "edit":
//                    showCustomerEdit(request, response);
                    break;
                case "delete":
//                    deleteCustomer(request, response);
                    break;
                case "search":
//                    searchCustomer(request, response);
                    break;
                default:
//                    listCustomer(request, response);
                    break;

            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//
//        }
    }
//    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//
//        List<Customer> listCustomer = customerSer.listCustomer();
//        request.setAttribute("listCustomer", listCustomer);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/Customer/listCustomer.jsp");
//        dispatcher.forward(request, response);
//    }
}
