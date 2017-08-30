package fileworker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sano on 30.08.2017.
 */
public class CSVWorker {
    private StringBuilder csvContent;

    public CSVWorker() {
    }

    // if flag is 0  content will be write in users.csv , 1 in requst.csv
    public void write(StringBuilder content, int flag,String fileName) throws IOException {
        if (flag == 0) {csvContent = new StringBuilder("user-id,install-date");
        } else if (flag == 1) {csvContent = new StringBuilder("user-id,request-date");
        } else {return;}
        csvContent.append("\n");
        csvContent.append(content);
        File csv = new File(fileName);
        if(csv.exists()){
            csv.delete();
        }

        FileWriter writer =new FileWriter(fileName,true);
        PrintWriter printWriter = new PrintWriter(writer,false);
        printWriter.write(csvContent.toString());
        printWriter.flush();
        printWriter.close();
        writer.close();


    }
}
