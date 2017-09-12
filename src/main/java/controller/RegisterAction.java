package controller;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAOImpl;
import entities.User;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sano on 11.09.2017.
 */
public class RegisterAction extends ActionSupport {
    private String name, mail, password;

    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    private User user;

    @Override
    public String execute() throws Exception {
        LocalDate localDate = new LocalDate();
        user.setName(name);
        user.setMail(mail);
        user.setPassword(password);
        user.setDate(java.sql.Date.valueOf(localDate.toString()));
        System.out.println();
        if(!userDAO.addUser(user)){
            return ERROR;
        }
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDAOImpl getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
