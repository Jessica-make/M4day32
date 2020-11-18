package org.spoto.dao;

import org.spoto.model.Account0;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

//新的dao;
@Mapper
public interface EmpMapper {

    //登录;
    List <Account0> newLogin(@Param("username") String username, @Param("passwd") String passwd);

    //新增之前判断是否已有该用户;
    Integer selectUser(@Param("username") String username);

    //新增;表示绑定到dao实现类的参数类型;
    Integer add(Account0 ac);

    //修改;
    //@Param表示绑定到dao实现类的参数类型;
    Integer change(@Param("id") Integer id,  @Param("username") String username,
                @Param("passwd") String passwd,@Param("role") String role,
                   @Param("status") String status, @Param("date1") Date date1);
    //删除;
    Integer delemp(@Param("ids") List<Integer> ids);

    //展现数据+分页;
    List<Account0>getList(RowBounds rb, @Param("username") String username, @Param("passwd") String passwd);

    //统计数据;
    Integer listCount(@Param("username") String username, @Param("passwd") String passwd);

    //查询账号;
    List <Account0> SELECTEmp(@Param("id")Integer id);

    //锁定账号
    Integer upDateEmp1(@Param("id")Integer id,@Param("status")String status);



}
