package org.spoto.service;

import org.spoto.model.Account0;
import org.spoto.utils.PageData;
import org.spoto.utils.TableData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpService {

    //第一个业务 从前端页面保存数据到数据库;
    boolean save(Account0 ac);

    //第二个业务 从数据库查询数据到表格;
    TableData <Account0> list(PageData pd);

    //第三个业务，从前端页面删除员工数据到数据库;
    void delete(List<Integer> ids);

    //锁定
    void LockAccount(Integer id);



}
