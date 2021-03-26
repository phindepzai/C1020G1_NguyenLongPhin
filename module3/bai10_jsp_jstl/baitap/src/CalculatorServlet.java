import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("number1"));
        int num2 = Integer.parseInt(request.getParameter("number2"));
        String calculation = request.getParameter("calculation");
        double result;
        switch (calculation){
            case "addition":
                result = Calculator.addition(num1,num2);
                break;
            case "subtraction":
                result = Calculator.subtraction(num1,num2);
                break;
            case "multiplication":
                result = Calculator.multiplication(num1,num2);
                break;
            default:
                if (num2 == 0){
                    request.setAttribute("result","number 2 must != 0!");
                    request.getRequestDispatcher("calculator.jsp").forward(request,response);
                }
                result = Calculator.division(num1,num2);
        }
        request.setAttribute("result",result);
        request.getRequestDispatcher("calculator.jsp").forward(request,response);
    }
}
