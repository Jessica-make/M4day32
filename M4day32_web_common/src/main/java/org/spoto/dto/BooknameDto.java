package org.spoto.dto;

import org.spoto.model.BookClass;
import org.spoto.model.Bookname;

//两个model写在一起
public class BooknameDto extends BookClass {

    private Bookname  bok;

    public BooknameDto() {
    }

    public BooknameDto(Bookname bok) {
        this.bok = bok;
    }

    public Bookname getBok() {
        return bok;
    }

    public void setBok(Bookname bok) {
        this.bok = bok;
    }
    //super.toString调用一下父类
    @Override
    public String toString() {
        return "BooknameDto{" +
                "bok=" + bok +
                ",pa=" + super.toString() +
                '}';
    }
}
