package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAOImpl;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by Sano on 12.09.2017.
 */
public class LoginAction extends ActionSupport {
    private String mail;
    private String password;
    @Autowired
    private UserDAOImpl userDAO;
    @Autowired
    private User user;

    @Override
    public String execute() throws Exception {

        if(mail==null || password==null){
            return INPUT;
        }


         if(userDAO.isLoginTrue(mail,password)) {
             Map session= ActionContext.getContext().getSession();
             session.put("logined","true");
             return SUCCESS;
         }
         return ERROR;
    }
    public String logOut()throws Exception{
        Map session =ActionContext.getContext().getSession();
        session.remove("logined");
        return SUCCESS;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }
}
