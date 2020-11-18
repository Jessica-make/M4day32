package org.spoto.model;

public class BookClass {

private Integer id;

private String bookclass;

    public BookClass() {
    }

    public BookClass(Integer id, String bookclass) {
        this.id = id;
        this.bookclass = bookclass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookclass() {
        return bookclass;
    }

    public void setBookclass(String bookclass) {
        this.bookclass = bookclass;
    }

    @Override
    public String toString() {
        return "bookclass{" +
                "id=" + id +
                ", bookclass='" + bookclass + '\'' +
                '}';
    }
}
