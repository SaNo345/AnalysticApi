package fileworker;

import entities.Request;
import entities.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Sano on 30.08.2017.
 */
public class CSVWorkerImpl implements CSVWorker {
    private StringBuilder csvContent;
    private  String userCSVpath;
    private  String reqCSVpath ;


    public CSVWorkerImpl() {
    }

    public boolean writeUser(List<User> users) throws IOException {
        if(users.isEmpty()){
            return false;
        }
        csvContent = new StringBuilder("User-id,instal-date" + "\n");


        for (User user : users) {
            csvContent.append(user.getId() + "," + user.getDate() + "\n");
        }


        File csv = new File(userCSVpath);

        if (csv.exists()) {
            //clean csv file
            PrintWriter printWriter = new PrintWriter(csv);
            printWriter.write("");
            printWriter.close();
        } else {
            csv.createNewFile();
        }

        System.out.println(csv.getAbsolutePath());

        FileWriter writer = new FileWriter(userCSVpath, true);
        PrintWriter printWriter = new PrintWriter(writer, false);
        printWriter.write(csvContent.toString());
        printWriter.flush();
        printWriter.close();
        writer.close();
        return true;

    }

    public boolean writeReq(List<Request> requests) throws IOException {
        csvContent = new StringBuilder("User-id,requets-date" + "\n");
        if(requests.isEmpty()){
            return false;
        }

        for (Request req : requests) {
            csvContent.append(req.getUser_id() + "," + req.getReq_date() + "\n");
        }


        File csv = new File(reqCSVpath);

        if (csv.exists()) {
            //clean csv file
            PrintWriter printWriter = new PrintWriter(csv);
            printWriter.write("");
            printWriter.close();
        } else {
            csv.createNewFile();
        }

        System.out.println(csv.getAbsolutePath());

        FileWriter writer = new FileWriter(reqCSVpath, true);
        PrintWriter printWriter = new PrintWriter(writer, false);
        printWriter.write(csvContent.toString());
        printWriter.flush();
        printWriter.close();
        writer.close();
        return true;

    }

    public String getUserCSVpath() {
        return userCSVpath;
    }

    public void setUserCSVpath(String userCSVpath) {
        this.userCSVpath = userCSVpath;
    }

    public String getReqCSVpath() {
        return reqCSVpath;
    }

    public void setReqCSVpath(String reqCSVpath) {
        this.reqCSVpath = reqCSVpath;
    }
}
