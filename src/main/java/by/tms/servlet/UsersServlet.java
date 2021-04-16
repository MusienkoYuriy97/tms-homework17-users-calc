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


@WebServlet(urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            resp.getWriter().println("List all Users: ");
            for (User user : userService.getUsersList()) {
                resp.getWriter().println(user);
            }
        } catch (UserException e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}
