package by.tms.servlet;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.CalculatorService;;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {
    CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userInSession = (User) req.getSession().getAttribute("user");

        if (userInSession != null){
            for (Operation operation : calculatorService.getOperation()) {
                if (userInSession.getUsername().equals(operation.getUsername())){
                    resp.getWriter().println(operation);
                }
            }
        }else {
            resp.getWriter().println("Please sign in or register new account.");
        }
    }
}
