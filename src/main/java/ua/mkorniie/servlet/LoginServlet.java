package ua.mkorniie.servlet;

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

        // CHANGE TO DB!
        try {
            if (login.equals("user") && password.equals("user")) {
                request.getRequestDispatcher("templates/user_view/success_user.html").forward(request, response);
            }
            else if (login.equals("admin") && password.equals("admin")) {
                request.getRequestDispatcher("admin").forward(request, response);
            }
            request.getRequestDispatcher("templates/user_view/no-user-found.html").forward(request, response);
        } catch (Exception e) {}
    }
}
