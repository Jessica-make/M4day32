package org.spoto.model;

import java.util.Date;

public class Bookclick {

    private Integer id;

    private Integer bookname_id;

    private Date readtime;

    private String user;

    public Bookclick() {
    }

    public Bookclick(Integer id, Integer bookname_id, Date readtime, String user) {
        this.id = id;
        this.bookname_id = bookname_id;
        this.readtime = readtime;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookname_id() {
        return bookname_id;
    }

    public void setBookname_id(Integer bookname_id) {
        this.bookname_id = bookname_id;
    }

    public Date getReadtime() {
        return readtime;
    }

    public void setReadtime(Date readtime) {
        this.readtime = readtime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bookclick{" +
                "id=" + id +
                ", bookname_id=" + bookname_id +
                ", readtime=" + readtime +
                ", user='" + user + '\'' +
                '}';
    }
}
