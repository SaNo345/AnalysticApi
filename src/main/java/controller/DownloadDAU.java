package Action;

import DAO.UserDAOImpl;
import com.opensymphony.xwork2.ActionSupport;
import fileworker.CSVWorker;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Created by Sano on 27.08.2017.
 */

public class DownloadDAU extends ActionSupport {
    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    private CSVWorker worker;

    private Date Inputdate;




    @Override
    public String execute() throws Exception {
        DateTime dateTime = new DateTime(Inputdate);
        String date=dateTime.toString("yyyy/MM/dd");
      if(!worker.writeReq(userDAO.getDAU(date))){
          return NONE;
      }
        return SUCCESS;
    }
    public UserDAOImpl getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public Date getInputdate() {
        return Inputdate;
    }

    public void setInputdate(Date inputdate) {
        Inputdate = inputdate;
    }
}
