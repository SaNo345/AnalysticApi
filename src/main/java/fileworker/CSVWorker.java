package fileworker;

import analysticapi.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sano on 30.08.2017.
 */
public class CSVWorker {
    private StringBuilder csvContent;
    private final String FileNAME="C:/Users/Sano/AnalysticApi4/data/users.csv";


    public CSVWorker() {
    }

    // if flag is 0  content will be write in users.csv , 1 in requst.csv
    public void write(User user, int flag) throws IOException {
        if (flag == 0) {
            csvContent = new StringBuilder("User-id,install-date");
        } else if (flag == 1) {
            csvContent = new StringBuilder("User-id,request-date");
        } else {
            return;
        }

        StringBuilder content=new StringBuilder(user.getId()+","+user.getDate());

        csvContent.append("\n");
        csvContent.append(content);
        File csv = new File(FileNAME);

        if (csv.exists()) {
            //clean csv file
            PrintWriter printWriter =new PrintWriter(csv);
            printWriter.write("");
            printWriter.close();
        }else{
            csv.createNewFile();
        }

        System.out.println(  csv.getAbsolutePath());

        FileWriter writer = new FileWriter(FileNAME, true);
        PrintWriter printWriter = new PrintWriter(writer, false);
        printWriter.write(csvContent.toString());
        printWriter.flush();
        printWriter.close();
        writer.close();

    }


}
