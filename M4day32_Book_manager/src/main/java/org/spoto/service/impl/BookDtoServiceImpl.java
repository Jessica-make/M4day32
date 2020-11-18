package org.spoto.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.RowBounds;
import org.spoto.dao.BookClassMapper;
import org.spoto.dto.BooknameDto;
import org.spoto.model.BookClass;
import org.spoto.model.Bookname;
import org.spoto.service.BookDtoService;
import org.spoto.utils.PageData;
import org.spoto.utils.PageUtils;
import org.spoto.utils.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

//所有联表查询的信息都放在这里
@Service
public class BookDtoServiceImpl implements BookDtoService {
    //1.调用Dao;
    @Resource
    private BookClassMapper mapperDto;

    @Resource
    private BookClassMapper bookClassMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TableData <BooknameDto> getBooknamebok(PageData pd) {
        //1.构造结果数据;
        TableData<BooknameDto> tds = new TableData<>(pd);

        //2.获取查询数据,参数校验;
        String bookclass1=null;
        String bookname=null;
        JSONObject sd= pd.getSd();
        if (pd.getSd()!=null){
            bookclass1=sd.getString("bookclass1");
            bookname=sd.getString("bookname");
        }
        //3.查询数据条数,没有错，确实是String的bookclass1传下去，因为他不影响我们查询;
        Integer count = bookClassMapper.listCountDto(bookclass1, bookname);
        tds.setDataCount(count);
        if (count<=0){
            return tds;
        }


        //PageIndex是属于TableData里面封装的属性，而这里还是要根据传下来的值进行分页公式;
        RowBounds rb  = PageUtils.getRowBounds(pd);
        //mapper调用getList的方法,得到的数据，设置到TableData里面，
        //5.那么在上一级controller那里，只要调用或者实例化TableData就可以取出所有的参数;
        List<BooknameDto> booknamebok = bookClassMapper.getBooknamebok(rb,bookclass1, bookname);
        //1.1搞事情！获取list数据
        for (BooknameDto list : booknamebok) {
            Bookname bok = list.getBok();
            String path = "http://127.0.0.1:8889/Bookimg?name=";
            String BookImage = bok.getImage();
            String image = path + BookImage;
            bok.setImage(image);
            tds.setDataList(booknamebok);
//            System.out.println(booknamebok);
        }
        return tds;

    }


}
