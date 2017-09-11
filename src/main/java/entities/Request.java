package analysticapi;

/**
 * Created by Sano on 09.09.2017.
 */
public class Request {
    private int id;
    private String req_date;
    private int user_id;

    public Request() {
    }

    public Request(int user_id, String req_date) {
        this.user_id=user_id;
        this.req_date = req_date;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReq_date() {
        return req_date;
    }

    public void setReq_date(String req_date) {
        this.req_date = req_date;
    }
}
