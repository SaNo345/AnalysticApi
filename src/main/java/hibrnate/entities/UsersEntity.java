package hibrnate.entities;

import java.sql.Date;

/**
 * Created by Sano on 02.09.2017.
 */
public class UsersEntity {
    private int userId;
    private String name;
    private String mail;
    private String password;
    private Date instalDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getInstalDate() {
        return instalDate;
    }

    public void setInstalDate(Date instalDate) {
        this.instalDate = instalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (instalDate != null ? !instalDate.equals(that.instalDate) : that.instalDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (instalDate != null ? instalDate.hashCode() : 0);
        return result;
    }
}
