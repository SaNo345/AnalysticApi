package controller;

import com.opensymphony.xwork2.ActionContext;
import dao.UserDAOImpl;
import com.opensymphony.xwork2.ActionSupport;
import entities.User;
import fileworker.CSVWorkerImpl;
import fileworker.ZipHelper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Map;


/**
 * Created by Sano on 27.08.2017.
 */

public class DownloadDAU extends ActionSupport {
    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    private CSVWorkerImpl worker;
    @Autowired
    private ZipHelper zip;
    @Autowired
    private User user;

    private Date Inputdate;
    private FileInputStream fileInputStream;
    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        if(session.get("logined")==null){
            return ERROR;
        }

        DateTime dateTime = new DateTime(Inputdate);
        String date=dateTime.toString("yyyy/MM/dd");

      if(!worker.writeReq(userDAO.getDAU(date))){
          //DAU in this date  empty !!
          return NONE;
      }
      worker.writeUser(userDAO.getUsers());
        zip.zipFiles("C:/Users/Sano/AnalysticApi4/data");

        fileInputStream = new FileInputStream(new File("C:/Users/Sano/AnalysticApi4/data.zip"));
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

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }
}
