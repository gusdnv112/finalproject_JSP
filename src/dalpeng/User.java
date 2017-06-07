package dalpeng;

import database.database;

/**
 * Created by Park on 2017-04-06.
 */
public class User {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    private int no;

    public User(int no, String id, int pw) {
        this.no = no;
        this.id = id;
        this.pw = pw;
    }

    private String id;
    private int pw;

}
