package org.spoto.model;

public class Bookchapter {

  private Integer id;

  private Integer bookname_id;

  private String chapter;

    public Bookchapter() {
    }

    public Bookchapter(Integer id, Integer bookname_id, String chapter) {
        this.id = id;
        this.bookname_id = bookname_id;
        this.chapter = chapter;
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

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return "bookchapter{" +
                "id=" + id +
                ", bookname_id=" + bookname_id +
                ", chapter='" + chapter + '\'' +
                '}';
    }
}
