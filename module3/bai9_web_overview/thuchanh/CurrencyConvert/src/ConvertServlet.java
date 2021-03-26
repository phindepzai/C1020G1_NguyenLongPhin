import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConvertServlet", urlPatterns = "/convert")
public class ConvertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float usd = Float.parseFloat(request.getParameter("usd"));
        float rate = Float.parseFloat(request.getParameter("rate"));
        double vnd = usd * rate;
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1>Rate: " + rate+ "</h1>");
        printWriter.println("<h1>USD: " + usd+ "</h1>");
        printWriter.println("<h1> VND: "+vnd+"</h1>");
        printWriter.println("</html>");
    }
}
