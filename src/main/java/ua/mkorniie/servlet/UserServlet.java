package ua.mkorniie.servlet;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import ua.mkorniie.DAO.UserDAO;
import ua.mkorniie.entity.User;
import ua.mkorniie.services.Path;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by mkorniie on 6/1/19.
 */
//@WebServlet(name = "UserServlet", urlPatterns = {"/new", "/insert", "/delete", "/edit", "/update" })
@WebServlet("/")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;
    private Configuration cfg;

    public void init_database() {
//        PoolProperties p = new PoolProperties();
//        p.setUrl("jdbc:mysql://localhost:3306/mysql");
//        p.setDriverClassName("com.mysql.jdbc.Driver");
//        p.setUsername("root");
//        p.setPassword("");
//        p.setJmxEnabled(true);
//        p.setTestWhileIdle(false);
//        p.setTestOnBorrow(true);
//        p.setValidationQuery("SELECT 1");
//        p.setTestOnReturn(false);
//        p.setValidationInterval(30000);
//        p.setTimeBetweenEvictionRunsMillis(30000);
//        p.setMaxActive(100);
//        p.setInitialSize(10);
//        p.setMaxWait(10000);
//        p.setRemoveAbandonedTimeout(60);
//        p.setMinEvictableIdleTimeMillis(30000);
//        p.setMinIdle(10);
//        p.setLogAbandoned(true);
//        p.setRemoveAbandoned(true);
//        p.setJdbcInterceptors(
//                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
//                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
//        DataSource datasource = new DataSource();
//        datasource.setPoolProperties(p);
//        String databaseHost = getServletContext().getInitParameter("db.username");
//        String databaseUser = getServletContext().getInitParameter("db.username");
//        String databasePassword = getServletContext().getInitParameter("db.password");
//
//        System.out.println(databaseHost);
//        System.out.println(databaseUser);
//        System.out.println(databasePassword);
    }

    public void init_freemarker() throws Exception {
        cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File(Path.getProjectPath() +
                "/web/WEB-INF/templates"));
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

//    TODO: handle ur exceptions like a man

    public void init() {

        init_database();
        try {
            init_freemarker();
        } catch (Exception e) {
            e.printStackTrace();
        }
        userDAO = new UserDAO();


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                case "/list":
                    listUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }










    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        List<User> listUser = userDAO.selectAll();
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("First", "abc@abc.com", "Ukraine"));
//        listUser.add(new User("Second", "def@def.com", "Ukraine"));
//        Template template = cfg.getTemplate("user-list.ftl");
        request.setAttribute("users", listUser);
        request.getRequestDispatcher(Path.getProjectPath() + "web/WEB-INF/views/user-list.ftl").forward(request, response);

    }














    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        userDAO.insert(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User book = new User(id, name, email, country);
        userDAO.update(book);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(id);
        response.sendRedirect("list");

    }
}
