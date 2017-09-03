package hibrnate.entities;

import java.sql.Date;

/**
 * Created by Sano on 02.09.2017.
 */
public class RequestEntity {
    private int reqId;
    private Date reqDate;

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestEntity that = (RequestEntity) o;

        if (reqId != that.reqId) return false;
        if (reqDate != null ? !reqDate.equals(that.reqDate) : that.reqDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reqId;
        result = 31 * result + (reqDate != null ? reqDate.hashCode() : 0);
        return result;
    }
}
