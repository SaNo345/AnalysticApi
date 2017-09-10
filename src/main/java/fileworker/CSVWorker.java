package fileworker;

import analysticapi.Request;
import analysticapi.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Sano on 30.08.2017.
 */
public class CSVWorker {
    private StringBuilder csvContent;
    private final String USERFileNAME = "C:/Users/Sano/AnalysticApi4/data/users.csv";
    private final String REQUESTFileNAME = "C:/Users/Sano/AnalysticApi4/data/request.csv";


    public CSVWorker() {
    }

    // if flag is 0  content will be write in users.csv , 1 in requst.csv
    public void writeUser(List<User> users) throws IOException {

        csvContent = new StringBuilder("User-id,instal-date" + "\n");


        for (User user : users) {
            csvContent.append(user.getId() + "," + user.getDate() + "\n");
        }


        File csv = new File(USERFileNAME);

        if (csv.exists()) {
            //clean csv file
            PrintWriter printWriter = new PrintWriter(csv);
            printWriter.write("");
            printWriter.close();
        } else {
            csv.createNewFile();
        }

        System.out.println(csv.getAbsolutePath());

        FileWriter writer = new FileWriter(USERFileNAME, true);
        PrintWriter printWriter = new PrintWriter(writer, false);
        printWriter.write(csvContent.toString());
        printWriter.flush();
        printWriter.close();
        writer.close();

    }

    public void writeReq(List<Request> requests) throws IOException {
        csvContent = new StringBuilder("User-id,requets-date" + "\n");
        if(requests.isEmpty()){
            return;
        }

        for (Request req : requests) {
            csvContent.append(req.getUser_id() + "," + req.getReq_date() + "\n");
        }


        File csv = new File(REQUESTFileNAME);

        if (csv.exists()) {
            //clean csv file
            PrintWriter printWriter = new PrintWriter(csv);
            printWriter.write("");
            printWriter.close();
        } else {
            csv.createNewFile();
        }

        System.out.println(csv.getAbsolutePath());

        FileWriter writer = new FileWriter(REQUESTFileNAME, true);
        PrintWriter printWriter = new PrintWriter(writer, false);
        printWriter.write(csvContent.toString());
        printWriter.flush();
        printWriter.close();
        writer.close();

    }


}
