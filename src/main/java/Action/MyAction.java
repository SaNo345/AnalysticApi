package Action;

import DAO.UserDAOImpl;
import analysticapi.User;
import com.opensymphony.xwork2.ActionSupport;
import fileworker.CSVWorker;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * Created by Sano on 27.08.2017.
 */

public class MyAction extends ActionSupport {
    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    private CSVWorker worker;



    @Override
    public String execute() throws Exception {
     worker.write(userDAO.getUsers().get(1),0);


        return SUCCESS;
    }
    public UserDAOImpl getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

}
