package ua.mkorniie.servlet;

import ua.mkorniie.DAO.UserDAO;
import ua.mkorniie.entity.Roles;
import ua.mkorniie.entity.User;
import ua.mkorniie.util.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // TODO: Это нафиг вообще нормальная практика? Гет в пост посылать
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("templates/login.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User u = userDAO.selectByName(login);

        //TODO: can be solved?
        try {
            if (u != null && u.getPasswordEncoded().equals(PasswordEncoder.getSHA(password))) {
                if (u.getRole() == Roles.USER) {
                    request.getRequestDispatcher("templates/user_view/success_user.html").forward(request, response);
                } else if (u.getRole() == Roles.ADMIN) {
                    request.getRequestDispatcher("admin").forward(request, response);
                }
            }
            request.getRequestDispatcher("templates/user_view/no-user-found.html").forward(request, response);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
