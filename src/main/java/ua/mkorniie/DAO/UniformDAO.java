package ua.mkorniie.DAO;

import ua.mkorniie.entity.Language;
import ua.mkorniie.entity.Roles;
import ua.mkorniie.entity.User;
import ua.mkorniie.util.PasswordEncoder;
import ua.mkorniie.util.StringUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniformDAO implements DAOInterface{
    private String jdbcURL = "jdbc:mysql://localhost:3306/workdb?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private String tableName;
    private ArrayList<String> columnNames;
    private ArrayList<String> pojoFields;
    private StatementsGenerator statementsGenerator;

    public static void main(String[] args) {
        User newUser = new User("Maria Korniiets", PasswordEncoder.getSHA("111"),
                Roles.ADMIN, "+380964498299", "mariakorniiets@gmail.com",
                Language.eng);
//
        UniformDAO uniformDAO = new UniformDAO("users", new String[]{"name", "pass", "roles", "phone", "email", "language"});
//
        System.out.println( uniformDAO.getConnection());
        uniformDAO.insert(newUser);
//
//        String query = "INSERT INTO users (name , pass , roles , phone , email , language) VALUES  ('secondUser' , '4f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb' , 'USER' , '+380964498299' , 'mariakorniiets@gmail.com' , 'eng');";


    }

    /**
     *
     * @param tableName - name of the table to be used
     * @param columnNames - names of columns (!WITHOUT ID!)
     */
    //TODO: Use "Class" instead of "Object"?
    public UniformDAO(String tableName, String[] columnNames) {
        this.tableName = tableName;
        this.columnNames = new ArrayList<>(Arrays.asList(columnNames));
        this.statementsGenerator = new StatementsGenerator();
    }

    //TODO: хрень архитектура вынести?
    class StatementsGenerator {

        String generateInsert(Object o) {
            pojoFields = StringUtil.wrapInQuotes(ReflectionUtil.getFieldValuesInStringButFirst(o));
            return  "INSERT INTO " + tableName +
                    " (" + String.join(" , ", columnNames) + ")" +
                    " VALUES " +
                    " (" + String.join(" , ", pojoFields) + ")" +
                    ";"  ;
        }

        String generateSelectById(Object o, Integer id) {
            return  "SELECT id, " + String.join(",", columnNames) +
                    " FROM " + tableName +
                    " WHERE  id = " + id +
                    ";" ;
        }

        String generateSelectAll(Object o) {
            return "SELECT * FROM " + tableName + ";";
        }

        String generateDelete(Object o, Integer id) {
            return "DELETE FROM " + tableName +
                    " WHERE id = " + id + ";";
        }

        String generateUdate(Object o, Integer id) {
            pojoFields = StringUtil.wrapInQuotes(ReflectionUtil.getFieldValuesInStringButFirst(o));
            StringBuffer s = new StringBuffer();
            for (int i = 0; i < columnNames.size(); i++) {
                if (i > 0) {
                    s.append(", ");
                }
                s.append(columnNames.get(i) + " = '" + pojoFields.get(i) + "'");
            }
            return "UPDATE " + tableName +
                    " SET " + s +
                    " WHERE id = " + id + ";";
        }
    }



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

    @Override
    //TODO: change to Statement
    public void insert(Object object) {
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(statementsGenerator.generateInsert(object))) {
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object selectById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statementsGenerator.generateInsert(object))) {
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Object> selectAll() {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statementsGenerator.generateInsert(object))) {
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statementsGenerator.generateInsert(object))) {
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Object object) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(statementsGenerator.generateInsert(object))) {
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
