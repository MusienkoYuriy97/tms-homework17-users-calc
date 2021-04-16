package by.tms.servlet;

import by.tms.entity.User;
import by.tms.exeptions.calc.OperationsNotFoundException;
import by.tms.service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calc")
public class CalcServlet extends HttpServlet {
    CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double x = Double.parseDouble(req.getParameter("num1"));
            double y = Double.parseDouble(req.getParameter("num2"));
            String command = req.getParameter("command");
            User userInSession = (User) req.getSession().getAttribute("user");

            if (req.getSession().getAttribute("user") != null){
                try {
                    double result = calculatorService.selectCommand(command,x,y,userInSession.getUsername());
                    resp.getWriter().println(command + " = " + result);
                } catch (OperationsNotFoundException e) {
                    resp.getWriter().println(e.getMessage() + "\n" +
                            "In my calculator, there are only such commands:\n" +
                            "sum - sum of numbers\n" +
                            "sub - subtracting numbers \n" +
                            "div - divide numbers\n" +
                            "mul - multiply numbers");
                }
            }else {
                resp.getWriter().println("Please sign in or register new account for starting a game.");
            }
        }catch (NumberFormatException e){
            resp.getWriter().println("Enter the correct data.");
        }
    }
}
