package analysticapi;


import java.sql.Date;

/**
 * Created by Sano on 03.09.2017.
 */
public class User {
    private int id;
    private String name;
    private String mail;
    private String password;
    private java.sql.Date date;

    public User() {
    }

    public User(int id, String name, String mail, String password, Date date) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
