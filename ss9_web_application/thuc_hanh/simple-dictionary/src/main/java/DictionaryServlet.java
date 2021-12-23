import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", urlPatterns = "/dictionary")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary =new HashMap<>();
        {
            dictionary.put("hello", "Xin chào");
            dictionary.put("how", "Thế nào");
            dictionary.put("book", "Quyển vở");
            dictionary.put("computer", "Máy tính");
        }
        String search = request.getParameter("txtSearch");
        String result = dictionary.get(search);
        String result2 = "Not found";

        if (result != null){
            request.setAttribute("transResult",result);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }
        else {
            request.setAttribute("transResult",result2);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
