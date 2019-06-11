package ua.mkorniie.servlet;

import ua.mkorniie.entity.Language;
import ua.mkorniie.entity.Roles;
import ua.mkorniie.entity.UsersEntity;
import ua.mkorniie.services.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    // TODO: Это нафиг вообще нормальная практика? Гет в пост посылать
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("templates/register-form.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersEntity newUser = new UsersEntity();
        newUser.setName(request.getParameter("name"));
        newUser.setPasswordHash(PasswordEncoder.getSHA(request.getParameter("password")));
        ArrayList<Roles> role = new ArrayList<>();
        role.add(Roles.USER);
        newUser.setRoles(role);
        newUser.setPhone(request.getParameter("phone"));
        newUser.setPhone(request.getParameter("email"));
        newUser.setLanguage(Language.valueOf(request.getParameter("language")));

    }
}
