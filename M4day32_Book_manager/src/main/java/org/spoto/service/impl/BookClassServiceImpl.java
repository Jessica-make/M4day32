package org.spoto.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.RowBounds;
import org.spoto.dao.BookClassMapper;
import org.spoto.model.Account0;
import org.spoto.model.BookClass;
import org.spoto.model.Bookname;
import org.spoto.service.BookClassService;
import org.spoto.utils.PageData;
import org.spoto.utils.PageUtils;
import org.spoto.utils.TableData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookClassServiceImpl implements BookClassService {

    @Resource
    private BookClassMapper bookClassMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<BookClass> booklist(Integer id) {
        List<BookClass> booklist = bookClassMapper.getList(id);
        return booklist;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBookcla(String bookclass) {
        List<BookClass> bookclass1 = bookClassMapper.getBookclass(bookclass);
//        System.out.println(bookclass1);
        for (BookClass idList : bookclass1) {
            String bookclass99 = idList.getBookclass();
            if (bookclass99.equals(bookclass)) {
                return false;
            }
        }
        bookClassMapper.addBookclass(bookclass);
        return true;
    }


    //新增图书;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveBook(Bookname bok) {
         bookClassMapper.addbook(bok);
    }

    //删除图书
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delBook(List<Integer> ids) {
        bookClassMapper.delBooks(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Bookname> list() {
        List<Bookname> daList = bookClassMapper.list();
        for (Bookname list:daList){
            String path="http://127.0.0.1:8889/Bookimg?name=";
            String BookImage = list.getImage();
            String image=path+BookImage;
            list.setImage(image);
        }
        return daList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Bookname> OneBookList(Integer id) {
        List<Bookname> oneList = bookClassMapper.OneBookList(id);
        for (Bookname list:oneList){
            String path="http://127.0.0.1:8889/Bookimg?name=";
            String BookImage = list.getImage();
            String image=path+BookImage;
            list.setImage(image);
        }
        return oneList;
    }





}
