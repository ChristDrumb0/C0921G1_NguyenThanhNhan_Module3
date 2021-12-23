import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "CurrencyExchangeServlet", value = "/convert")
public class CurrencyExchangeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));

        float vnd = rate * usd;

        request.setAttribute("resultExchange",vnd);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}
