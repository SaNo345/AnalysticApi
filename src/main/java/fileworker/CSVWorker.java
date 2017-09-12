package fileworker;

import entities.Request;
import entities.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sano on 11.09.2017.
 */
public interface CSVWorker {

    boolean writeUser(List<User> users) throws IOException;
    boolean writeReq(List<Request> requests) throws IOException;
}
