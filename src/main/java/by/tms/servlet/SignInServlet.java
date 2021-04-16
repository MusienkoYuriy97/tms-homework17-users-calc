package by.tms.servlet;

import by.tms.entity.User;
import by.tms.exeptions.user.UserException;
import by.tms.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/signIn")
public class SignInServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            if (req.getSession().getAttribute("user") == null){
                User userInSession = userService.getLoggedInUser(username,password);
                resp.getWriter().printf("User:%s - you are logged in system.", username);
                req.getSession().setAttribute("user", userInSession);
            }else {
                resp.getWriter().printf("You are already in system.\n" +
                        "Please log out to sign in or register new account.");
            }
        } catch (UserException e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}
