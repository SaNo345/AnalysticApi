package DAO;

import analysticapi.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Sano on 01.09.2017.
 */
public interface UsersDAO {
    boolean addUser(User user) throws SQLException;
    boolean isLoginTrue(User user);
    List<User>getDAU(Date date);
    List<User>getUsers() throws SQLException;
}
