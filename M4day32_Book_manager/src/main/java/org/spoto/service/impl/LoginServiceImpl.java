package org.spoto.service.impl;

import org.spoto.dao.BookClassMapper;
import org.spoto.model.Account0;
import org.spoto.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    //1.调用Dao;
    @Resource
    private BookClassMapper mapper;

    @Override
    public boolean newLogin(String username, String passwd) {
        List<Account0> AccountList = mapper.newLogin(username, passwd);
//        System.out.println(AccountList);
        for (Account0 list:AccountList){
            String status = list.getStatus();
            //System.out.println(status);
            if (status.equals("可用")){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
