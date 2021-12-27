package bai_tap.cus_list;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerListServlet" , urlPatterns = {"/customerList"})
public class CustomerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerList> cusList= new ArrayList<>();
        {
            cusList.add(new CustomerList("Mai Van Hoan","1983-08-20","Ha Noi","https://icdn.dantri.com.vn/2020/12/21/khi-1-docx-1608525944555.png"));
            cusList.add(new CustomerList("Nguyen Van Nam","1983-08-21","Bac Giang","https://www.thuocdantoc.org/wp-content/uploads/2019/12/cao-khi-1-1.jpg"));
            cusList.add(new CustomerList("Nguyen Thai Hoa","1983-08-22","Nam Dinh","https://cdn.24h.com.vn/upload/2-2019/images/2019-05-19/1558263357-490-khi-dot-biet-de-tang-cho-cai-chet-cua-dong-loai-giong-nhu-con-nguoi-khi-1-1558235907-width564height523.png"));
            cusList.add(new CustomerList("Tran Dang Khoa","1983-08-17","Ha Tay","https://media.ex-cdn.com/EXP/media.phatgiao.org.vn/files/lan.anh/2019/01/03/vooc-son-tra-1521.jpg"));
            cusList.add(new CustomerList("Nguyen Dinh Thi","1983-08-19","Ha Noi","https://icdn.dantri.com.vn/thumb_w/660/2021/08/22/images2393324z2697546543992119fa12388613ef18b4cfb8d3b74e01a-1629624003486.jpeg"));
        }
        request.setAttribute("customList",cusList);
        request.getRequestDispatcher("bai_tap_customer_list/index3.jsp").forward(request,response);
    }
}
