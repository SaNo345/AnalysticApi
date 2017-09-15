package dao;

import entities.Request;
import entities.User;
import org.joda.time.LocalDate;
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
        String insertSql = "INSERT INTO users (name,mail,password,instal_date) VALUES (?,?,?,?)";
        LocalDate localDate = new LocalDate();
        Date sqlDate = java.sql.Date.valueOf(localDate.toString());

        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getMail());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setDate(4, sqlDate);
        int sqlResult = preparedStatement.executeUpdate();
        if (sqlResult == 0) {

            connection.close();
            return false;
        }
        connection.close();
        return true;
    }

    public boolean isLoginTrue(String mail,String password) throws SQLException {
        String SelectSql="SELECT user_id FROM users WHERE mail='"+mail+"'"+" AND password='"+password+"'";
        String InsertSql="INSERT INTO request(req_date,user_id) VALUES(?,?) ";

        Connection conn = dataSource.getConnection();
        Statement statement=conn.createStatement();
        ResultSet resultSet=statement.executeQuery(SelectSql);
            if (resultSet.next()){
                PreparedStatement preparedStatement=conn.prepareStatement(InsertSql);
                LocalDate localDate = new LocalDate();
                Date sqlDate = java.sql.Date.valueOf(localDate.toString());
                preparedStatement.setDate(1,sqlDate);

                preparedStatement.setInt(2,resultSet.getInt("user_id"));
                 preparedStatement.executeUpdate();

                conn.close();
                return true;
            }
            conn.close();
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
