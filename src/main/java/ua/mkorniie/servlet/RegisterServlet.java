package ua.mkorniie.servlet;

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
//        UsersEntity newUser = new UsersEntity();
//        newUser.setName(request.getParameter("first_name") + " " + request.getParameter("last_name"));
//        newUser.setPasswordHash(PasswordEncoder.getSHA(request.getParameter("password")));
//        ArrayList<Roles> role = new ArrayList<>();
//        role.add(Roles.USER);
//        newUser.setRoles(role);
//        newUser.setPhone(request.getParameter("phone"));
//        newUser.setEmail(request.getParameter("email"));
//        //TODO: connect to filter???
//        newUser.setLanguage(Language.eng);
//
    }
}
