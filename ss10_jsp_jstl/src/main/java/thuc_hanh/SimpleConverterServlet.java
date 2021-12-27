package thuc_hanh;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "SimpleCalculationServlet", urlPatterns = {"/converter"})
public class SimpleConverterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("thuc_hanh_converter/converter.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("thuc_hanh_converter/index1.jsp").forward(request,response);
    }
}
