package org.spoto.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.spoto.dto.BooknameDto;
import org.spoto.model.Account0;
import org.spoto.model.BookClass;
import org.spoto.model.Bookname;
import org.spoto.utils.PageData;
import org.spoto.utils.TableData;

import java.util.List;

@Mapper
public interface BookClassMapper {
    //登录;
    List <Account0> newLogin(@Param("username") String username, @Param("passwd") String passwd);

    //下拉框查询图书分类
    List <BookClass> getList(@Param("id")Integer id);

    //新增图书分类查询是否存在相同分类
    List<BookClass> getBookclass(@Param("bookclass") String bookclass);


    //新增图书分类
    Integer addBookclass( @Param("bookclass") String bookclass);

    //新增图书;表示绑定到dao实现类的参数类型;
    Integer addbook(Bookname bok);

    //删除图书
    Integer delBooks(@Param("ids")List <Integer> ids);

    //微信查询图书
    List <Bookname> list();

    //微信第二页查询单本书
    List <Bookname> OneBookList(Integer id);

    //联表统计分页数据;
    Integer listCountDto(@Param("bookclass1") String bookclass1, @Param("bookname") String bookname);

    //联表查询,书的信息,BooknameDto里面有个两个对象，多个信息，用List
    List <BooknameDto> getBooknamebok(RowBounds rb,@Param("bookclass1") String bookclass1, @Param("bookname") String bookname);

}
