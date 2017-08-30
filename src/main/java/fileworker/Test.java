package fileworker;

import java.io.IOException;

/**
 * Created by Sano on 30.08.2017.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        CSVWorker worker = new CSVWorker();
        StringBuilder text= new StringBuilder("1;10:10:2017");
        text.append("\n");
        text.append("2;15:1:2017");

        worker.write(text,0,"data/users.csv");

        text= new StringBuilder("1;2-12-2016");
        worker.write(text,1,"data/request.csv");

    }
}
