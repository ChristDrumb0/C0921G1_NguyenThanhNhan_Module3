package controller;

import model.User;
import service.ImpService;
import service.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/users", ""})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Service userService;

    public void init() {

        userService = new ImpService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        //thuc hanh ss12
//        userService.insertUser(newUser);
        //thục hành ss13
        userService.insertUserStore(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User that = new User(id, name, email, country);
//        userService.updateUser(that);
        //bai tap 13 1
        userService.updateUserStore(that);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Edit.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    newUserForm(request, response);
                    break;
                case "edit":
                    editUserForm(request, response);
                    break;
                case "delete":
                    deleteUserForm(request, response);
                    break;
                case "search":
                    searchUser(request, response);
                    break;
                case "sort":
                    sortUser(request,response);
                    break;

                case "permision":
                    addUserPermision(request, response);
                    break;

                case "test-without-tran":
                    testWithoutTran(request, response);
                    break;

                case "test-use-tran":
                    testUseTran(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    //thục hành 13 4
    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {

        userService.insertUpdateUseTransaction();

    }

    //thục hành 13 3
    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {

        userService.insertUpdateWithoutTransaction();

    }

    //thục hành 13 2
    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {

        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");

        int[] permision = {1, 2, 4};

        userService.addUserTransaction(user, permision);

    }

    private void sortUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String something = request.getParameter("sortByName");
        List<User> listUsers = userService.sortByName(something);
        request.setAttribute("listUser", listUsers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/List.jsp");
        dispatcher.forward(request, response);
    }

    private void searchUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String something = request.getParameter("search");
        List<User> listUsers = userService.searchByCountry(something.toLowerCase());
        request.setAttribute("listUser", listUsers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/List.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

//        List<User> listUser = userService.selectAllUsers();

        //bai tap 13 1
        List<User> listUser = userService.viewUserStore();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/List.jsp");
        dispatcher.forward(request, response);
    }

    private void newUserForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Create.jsp");
        dispatcher.forward(request, response);
    }

    private void editUserForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //thực hành ss12
//        User existingUser = userService.selectUser(id);
        //thục hành ss13
        User existingUser = userService.getUserById(id);



        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void deleteUserForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
//        userService.deleteUser(id);

        //bai tap 13 1
        userService.deleteUserStore(id);

        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/List.jsp");
        dispatcher.forward(request, response);
    }
}

