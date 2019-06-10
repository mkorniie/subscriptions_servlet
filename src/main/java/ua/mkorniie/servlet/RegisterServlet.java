package ua.mkorniie.servlet;

import ua.mkorniie.entity.Role;
import ua.mkorniie.entity.User;
import ua.mkorniie.entity.catalogue.Language;
import ua.mkorniie.services.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.ArrayList;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    // TODO: Это нафиг вообще нормальная практика? Гет в пост посылать
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("templates/user-form.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User newUser = new User();
        newUser.setName(request.getParameter("name"));
        newUser.setPasswordEncoded(PasswordEncoder.getSHA(request.getParameter("password")));
        ArrayList<Role> role = new ArrayList<>().add(Role.USER)
        newUser.setRoles(role);
        newUser.setPhone(request.getParameter("phone"));
        newUser.setPhone(request.getParameter("email"));
        newUser.setLanguage(Language.valueOf(request.getParameter("language")));

    }
}
