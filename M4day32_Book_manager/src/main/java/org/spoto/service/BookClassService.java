package org.spoto.service;

import org.spoto.model.Account0;
import org.spoto.model.BookClass;
import org.spoto.model.Bookname;
import org.spoto.utils.PageData;
import org.spoto.utils.TableData;

import java.util.List;

public interface BookClassService {
    //查询图书分类
    List <BookClass> booklist(Integer id);


    //新增图书分类
    boolean saveBookcla(String bookclass);

    //新增图书
    void saveBook(Bookname bok);

    //删除图书
    void delBook(List <Integer> ids);

    //微信查询图书;
    List <Bookname> list();

    //微信第二页查询单本书
    List <Bookname> OneBookList(Integer id);


}
