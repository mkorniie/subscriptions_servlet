package ua.mkorniie.servlet;

import ua.mkorniie.DAO.UserDAO;
import ua.mkorniie.entity.Language;
import ua.mkorniie.entity.Roles;
import ua.mkorniie.entity.User;
import ua.mkorniie.util.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    // TODO: Это нафиг вообще нормальная практика? Гет в пост посылать
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("templates/register-form.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User newUser = new User();
        newUser.setFullName(request.getParameter("first_name") + " " + request.getParameter("last_name"));
        newUser.setPasswordEncoded(PasswordEncoder.getSHA(request.getParameter("password")));
        newUser.setRole(Roles.USER);
        newUser.setPhone(request.getParameter("phone"));
        newUser.setEmail(request.getParameter("email"));
//        //TODO: connect to filter???
        newUser.setLanguage(Language.eng);

        UserDAO userDAO = new UserDAO();
        userDAO.insert(newUser);
//
    }
}
