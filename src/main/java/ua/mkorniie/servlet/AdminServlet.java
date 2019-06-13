package ua.mkorniie.servlet;

import ua.mkorniie.DAO.PublisherDAO;
import ua.mkorniie.DAO.UserDAO;
import ua.mkorniie.entity.Language;
import ua.mkorniie.entity.Publisher;
import ua.mkorniie.entity.Roles;
import ua.mkorniie.entity.User;
import ua.mkorniie.util.DeleteUserCommand;
import ua.mkorniie.util.PasswordEncoder;
import ua.mkorniie.util.ToAdminCommand;
import ua.mkorniie.util.ToUserCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(urlPatterns = {"/admin", "/admin-users", "/admin-tables", "/admin-stats", "/admin-update", "/admin-users-update"})
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/admin":
                doGet(request, response);
                break;
            case "/admin-update":
                String name = request.getParameter("name");
                String country =request.getParameter("country");
                String description = request.getParameter("desc");
                new PublisherDAO().insert(new Publisher(name, country, description));
                showAdminPage(request, response);
                break;
            case "/admin-users-update":
                name = request.getParameter("name");
                String password = PasswordEncoder.getSHA(request.getParameter("pass"));
                Roles  role = Roles.valueOf(request.getParameter("role"));
                String phone = request.getParameter("phone");
                String email = request.getParameter("mail");
                Language lang =Language.valueOf(request.getParameter("lang"));
                new UserDAO().insert(new User(name, password, role, phone, email, lang));
                showUserTable(request, response);
                break;
            default:
                showNewForm(request, response, "success_admin.jsp");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/admin":
                processAdminRequest(request, response);
                break;
            case "/admin-users":
                processUserManagementRequest(request, response);
                break;
            case "/admin-tables":
                showNewForm(request, response, "tables.jsp");
                break;
            case "/admin-stats":
                showNewForm(request, response, "statistics.jsp");
                break;
            default:
                showNewForm(request, response, "success_admin.jsp");
                break;
        }
    }

    //TODO: это не безопасно - что делать?
    private void showNewForm(HttpServletRequest request, HttpServletResponse response, String filename)
            throws ServletException, IOException {
        String templatePath = "templates/admin_view/";
        request.getRequestDispatcher(templatePath + filename).forward(request, response);
    }

    private void showAdminPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Publisher> publishers = new PublisherDAO().selectAll();
        request.setAttribute("publishers", publishers);
        showNewForm(request, response, "success_admin.jsp");
    }

    private void processAdminRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String method = request.getParameter("method");
        String id = request.getParameter("id");

        if(method != null && id != null && method.equals("remove")) {
            try {
                Integer num = Integer.parseInt(id);
                new PublisherDAO().delete(num);
            } catch (NumberFormatException e) {
            }
        }
        showAdminPage(request, response);
    }

    private void processUserManagementRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String method = request.getParameter("method");
        String id = request.getParameter("id");

        if(method != null && id != null) {
            if (method.equals("remove"))
                new DeleteUserCommand().execute(id);
            else if (method.equals("priviledge_a")){
                new ToAdminCommand().execute(id);
            }
            else if (method.equals("priviledge_u")){
                new ToUserCommand().execute(id);
            }
        }
        showUserTable(request, response);
    }

    private void showUserTable(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> userList = new UserDAO().selectAll();
        request.setAttribute("users", userList);
        showNewForm(request, response, "users_management.jsp");
    }
}
