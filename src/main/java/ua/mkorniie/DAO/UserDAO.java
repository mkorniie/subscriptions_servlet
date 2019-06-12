//package ua.mkorniie.DAO;
//
//import ua.mkorniie.entity.Roles;
//import ua.mkorniie.entity.User;
//import ua.mkorniie.util.PasswordEncoder;
//
//import java.util.List;
//
///**
// * Created by mkorniie on 6/1/19.
// */
//public class UserDAO implements DAOInterface<User> {
//    private String jdbcURL = "jdbc:mysql://localhost:3306/db?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    private String jdbcUsername = "root";
//    private String jdbcPassword = "";
//
//    public static void main(String[] args) {
//        UserDAO userDAO = new UserDAO();
//        System.out.println(userDAO.getConnection());
//
//
//        User u = new User("Maria Korniiets", PasswordEncoder.getSHA("111"), Roles.ADMIN,"+380964498299", "mymail@mail.com", Language.eng);
//        userDAO.insert(u);
//        List<User> list = userDAO.selectAll();
//        for (User user : list) {
//            System.out.println(user);
//        }
//    }
//
//    /**
//     * TODO: refactor this shit
//     */
//    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, password_hash, roles, phone, email, language) VALUES " +
//            " (?, ?, ?, ?, ?, ?);";
////
//    private static final String SELECT_USER_BY_ID = "SELECT id, name, password_hash, roles, phone, email, language FROM users WHERE id = ?;";
//    private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
//    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?;";
//    private static final String UPDATE_USERS_SQL = "UPDATE users SET name = ?, password_hash= ?, roles=?, phone=?, email=?, language=?  where id = ?;";
//
//    /**
//     * TODO: change access level
//     */
//    public Connection getConnection() {
//
//
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    public void insert(User object) {
//        System.out.println(INSERT_USERS_SQL);
//
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//            preparedStatement.setString(1, object.getName());
//            preparedStatement.setString(2, object.getEmail());
//            preparedStatement.setString(3, object.getCountry());
//            preparedStatement.setString(4, object.getCountry());
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * TODO: костыль с лонгом (инт к лонгу); исправить!
//     * TODO: вынести цикл в отдельный метод, возможно использовать рефлекшен
//     *
//     * @param id
//     * @return
//     */
//    public User selectById(int id) {
//        User user = null;
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
//
//            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                user = new User(new Long(id), name, email, country);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
//
//    /**
//     * TODO: костыль с лонгом (инт к лонгу); исправить!
//     */
//    public List<User> selectAll() {
//        List<User> users = new ArrayList<>();
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
//                users.add(new User((long) id, name, email, country));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    public boolean delete(int id) {
//        boolean rowDeleted = false;
//        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
//            statement.setInt(1, id);
//            rowDeleted = statement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rowDeleted;
//    }
//
//    public boolean update(User object) {
//        boolean rowUpdated = false;
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
//            statement.setString(1, object.getFullName());
//            statement.setString(2, object.getPasswordEncoded());
//            statement.setString(3, object.getRole().toString());
//            statement.setString(4, object.getPhone());
//            statement.setString(5, object.getPhone());
//            statement.setString(6, object.getPhone());
//            statement.setString(7, object.getPhone());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rowUpdated;
//    }
//}
