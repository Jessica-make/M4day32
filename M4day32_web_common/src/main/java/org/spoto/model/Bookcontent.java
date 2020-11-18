package org.spoto.model;

public class Bookcontent {
    private Integer id;

    private Integer bookchapter_id;

    private String bookcontent;

    public Bookcontent() {
    }

    public Bookcontent(Integer id, Integer bookchapter_id, String bookcontent) {
        this.id = id;
        this.bookchapter_id = bookchapter_id;
        this.bookcontent = bookcontent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookchapter_id() {
        return bookchapter_id;
    }

    public void setBookchapter_id(Integer bookchapter_id) {
        this.bookchapter_id = bookchapter_id;
    }

    public String getBookcontent() {
        return bookcontent;
    }

    public void setBookcontent(String bookcontent) {
        this.bookcontent = bookcontent;
    }

    @Override
    public String toString() {
        return "bookcontent{" +
                "id=" + id +
                ", bookchapter_id=" + bookchapter_id +
                ", bookcontent='" + bookcontent + '\'' +
                '}';
    }
}
