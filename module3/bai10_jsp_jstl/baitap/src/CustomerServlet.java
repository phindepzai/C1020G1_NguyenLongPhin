import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Mai Văn Hoàn",
                "1983-08-20", "Hà Nội",
                "https://media.travelmag.vn/files/thuannguyen/2020/04/25/cach-chup-anh-dep-tai-da-lat-1-2306.jpeg"));
        customerList.add(new Customer("Nguyễn Văn Nam",
                "1983-08-21", "Bắc Giang",
                "https://kenh14cdn.com/2020/6/11/lythanhco983089727148871457275272847624881642748543n-1591861538137487491670.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam",
                "1983-08-21", "Bắc Giang",
                "image/hhhh.PNG"));
        request.setAttribute("list", customerList);
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }
}
