package dao;

import entities.Request;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sano on 01.09.2017.
 */
@Repository
public class UserDAOImpl implements UsersDAO {

    @Autowired
    private DataSource dataSource;


    public UserDAOImpl() {
    }


    public boolean addUser(User user) throws SQLException {
        Connection connection = dataSource.getConnection();
        String insertSql = "INSERT INTO users (name,mail,password) VALUES (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getMail());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.executeUpdate();
        return false;
    }

    public boolean isLoginTrue(User user) {
        return false;
    }

    public List<Request> getDAU(String date) throws SQLException {

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        List<Request> requests = new ArrayList<Request>();

        ResultSet result = statement.executeQuery(
                "SELECT user_id FROM request WHERE req_date=" + "'" + date + "'");

        while (result.next()) {
            Request request = new Request(result.getInt("user_id"), date);
            requests.add(request);
        }
        connection.close();
        return requests;
    }


    public List<User> getUsers() throws SQLException {

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        List<User> users = new ArrayList<User>();

        ResultSet result = statement.executeQuery("SELECT * FROM users");

        while (result.next()) {
            User user = new User(result.getInt("user_id"),
                    result.getString("name"),
                    result.getString("mail"),
                    result.getString("password"),
                    result.getDate("instal_date"));
            users.add(user);
        }
        connection.close();
        return users;
    }


}
