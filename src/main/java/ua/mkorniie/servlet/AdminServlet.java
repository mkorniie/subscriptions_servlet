package ua.mkorniie.servlet;

import ua.mkorniie.DAO.PublisherDAO;
import ua.mkorniie.entity.Publisher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin", "/admin/users", "/admin/tables", "/admin/stats"})
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/admin":
                List<Publisher> publishers = new PublisherDAO().selectAll();
                request.setAttribute("publishers", publishers);
                showNewForm(request, response, "success_admin.jsp");
                break;
            case "/admin/users":
                showNewForm(request, response, "user_management.jsp");
                break;
            case "/admin/tables":
                showNewForm(request, response, "tables.jsp");
                break;
            case "/admin/stats":
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
}
