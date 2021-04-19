package by.tms.servlet;

import by.tms.exeptions.user.UserException;
import by.tms.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        //default
        int age = -1;
        if (req.getParameter("age") != null){
            age = Integer.parseInt(req.getParameter("age"));
        }
        String password = req.getParameter("password");

        if (req.getSession().getAttribute("user") == null){
            try {
                userService.userRegister(username,fname,lname,age,password);
                resp.getWriter().printf("User username:%s is successfully registered.",username);
            } catch (UserException e) {
                resp.getWriter().println(e.getMessage());
            }
        }else {
            resp.getWriter().println("You are in action account.\n" +
                    "If you want to register a new account please log out.");
        }
    }
}
