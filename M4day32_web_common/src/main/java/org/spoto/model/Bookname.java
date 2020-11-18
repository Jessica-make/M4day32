package org.spoto.model;

import java.util.Date;

public class Bookname {
    private Integer id;

    private Integer bookclass_id;

    private String bookname;

    private String image;

    private String author;

    private String introduce;
    //上架时间
    private Date date;

    public Bookname() {
    }

    public Bookname(Integer id, Integer bookclass_id, String bookname, String image, String author, String introduce, Date date) {
        this.id = id;
        this.bookclass_id = bookclass_id;
        this.bookname = bookname;
        this.image = image;
        this.author = author;
        this.introduce = introduce;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookclass_id() {
        return bookclass_id;
    }

    public void setBookclass_id(Integer bookclass_id) {
        this.bookclass_id = bookclass_id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bookname{" +
                "id=" + id +
                ", bookclass_id=" + bookclass_id +
                ", bookname='" + bookname + '\'' +
                ", image='" + image + '\'' +
                ", author='" + author + '\'' +
                ", introduce='" + introduce + '\'' +
                ", date=" + date +
                '}';
    }
}
