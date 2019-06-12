package ua.mkorniie.DAO;

import ua.mkorniie.entity.Language;
import ua.mkorniie.entity.Roles;
import ua.mkorniie.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/workdb?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, pass, roles, phone, email, language) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "SELECT id, name, pass, roles, phone, email, language FROM users WHERE id = ?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?;";
    private static final String UPDATE_USERS_SQL = "UPDATE users SET name=?, pass=?, roles=?, phone=?, email=?, language=? where id = ?;";
    private static final String SELECT_USER_BY_NAME = "SELECT id, name, pass, roles, phone, email, language FROM users WHERE name = ?;";

    /**
     * TODO: change access level
     */
    private Connection getConnection() {


        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insert(User object) {
        System.out.println(INSERT_USERS_SQL);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, object.getFullName());
            preparedStatement.setString(2, object.getPasswordEncoded());
            preparedStatement.setString(3, object.getRole().toString());
            preparedStatement.setString(4, object.getPhone());
            preparedStatement.setString(5, object.getEmail());
            preparedStatement.setString(6, object.getLanguage().toString());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO: костыль с лонгом (инт к лонгу); исправить!
     * TODO: вынести цикл в отдельный метод, возможно использовать рефлекшен
     *
     * @param id
     * @return
     */
    public User selectById(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {

            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String pass = rs.getString("pass");
                Roles role = Roles.valueOf(rs.getString("roles"));
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                Language language = Language.valueOf(rs.getString("language"));
                user = new User(id, name, pass, role, phone, email, language);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User selectByName(String name) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME);) {

            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String pass = rs.getString("pass");
                Roles role = Roles.valueOf(rs.getString("roles"));
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                Language language = Language.valueOf(rs.getString("language"));
                user = new User(id, name, pass, role, phone, email, language);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * TODO: костыль с лонгом (инт к лонгу); исправить!
     */
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pass = rs.getString("pass");
                Roles role = Roles.valueOf(rs.getString("roles"));
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                Language language = Language.valueOf(rs.getString("language"));
                users.add(new User(id, name, pass, role, phone, email, language));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean delete(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    //TODO: refactor
    public boolean update(User object) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, object.getFullName());
            statement.setString(2, object.getPasswordEncoded());
            statement.setString(3, object.getRole().toString());
            statement.setString(4, object.getPhone());
            statement.setString(5, object.getEmail());
            statement.setString(6, object.getLanguage().toString());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
