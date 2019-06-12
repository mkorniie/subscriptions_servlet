package ua.mkorniie.DAO;

import ua.mkorniie.entity.Language;
import ua.mkorniie.entity.Publisher;
import ua.mkorniie.entity.Roles;
import ua.mkorniie.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO extends AbstractDAO{
    private static final String INSERT_USERS_SQL = "INSERT INTO publishers" + "  (name, country, description) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "SELECT id, name, country, description FROM publishers WHERE id = ?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM publishers;";
    private static final String DELETE_USERS_SQL = "DELETE FROM publishers WHERE id = ?;";
    private static final String UPDATE_USERS_SQL = "UPDATE publishers SET name=?, country=?, description=? where id = ?;";
    private static final String SELECT_USER_BY_NAME = "SELECT id, name, country, description FROM publishers WHERE name = ?;";

    private void setParameters(PreparedStatement preparedStatement, Publisher object) throws SQLException {
        preparedStatement.setString(1, object.getName());
        preparedStatement.setString(2, object.getCountry());
        preparedStatement.setString(3, object.getDescription());
    }

    public void insert(Publisher object) {
        System.out.println(INSERT_USERS_SQL);

        try (Connection connection = Connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

            setParameters(preparedStatement, object);
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
    public Publisher selectById(int id) {
        Publisher publisher = null;
        try (Connection connection = Connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String country = rs.getString("country");
                String description =rs.getString("description");
                publisher = new Publisher(id, name, country, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publisher;
    }

    public Publisher selectByName(String name) {
        Publisher publisher = null;
        try (Connection connection = Connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME)) {

            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String country = rs.getString("country");
                String description =rs.getString("description");
                publisher = new Publisher(id, name, country, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publisher;
    }

    /**
     * TODO: костыль с лонгом (инт к лонгу); исправить!
     */
    public List<Publisher> selectAll() {
        List<Publisher> publishers = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String description =rs.getString("description");
                publishers.add(new Publisher(id, name, country, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishers;
    }

    public boolean delete(int id) {
        return super.delete(id, DELETE_USERS_SQL);
    }


    //TODO: refactor
    public boolean update(Publisher object) {
        boolean rowUpdated = false;
        try (Connection connection = Connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, object.getName());
            statement.setString(2, object.getCountry());
            statement.setString(3, object.getDescription());
            statement.setInt(4, object.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
