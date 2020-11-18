package org.spoto.controller;

import org.spoto.model.Account0;
import com.alibaba.fastjson.JSONObject;
import org.spoto.service.EmpService;
import org.spoto.service.LoginService;
import org.spoto.utils.PageData;
import org.spoto.utils.StringUtils;
import org.spoto.utils.TableData;
import org.spoto.utils.WebUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class AccountController {

    //接口包括实现类全部交给spring管理,不需要bean了;
    @Resource
    private EmpService as;

    @Resource
    private LoginService ls;

  //展现数据;
  @RequestMapping("/EList.ajax")
  public String EmpList(PageData pd){
      TableData<Account0> list = as.list(pd);
      return WebUtils.getReturnData(list);
  }

  //给用户名;
  @RequestMapping("/MainList.ajax")
  public String MainList(HttpServletRequest request){
      Object username = request.getSession().getAttribute("logined");
      //1.返回数据;
      JSONObject data = new JSONObject();
      data.put("username",username);
      return data.toJSONString();
  }

   //登录
   @RequestMapping("/login.ajax")
   public String LoginServer(String username, String passwd, HttpServletRequest request){
      //定义一个状态码;
      int code=0;
      //2.参数校验;
//        //isAllNotEmpty 全都不为空;加了！表示有一个是空的;
      if (!StringUtils.isAllNotEmpty(username,passwd)){
          //空参数操作;
          code=-1;
      }else {
          //3.调用业务处理;
          boolean logined = ls.newLogin(username, passwd);
          if (logined){
              request.getSession().setAttribute("logined",username);
              code=0;
          }else {
              code=-2;
          }
      }
      //4.处理结果，响应出去;
      JSONObject data = new JSONObject();
      data.put("code",code);
      return data.toJSONString();
   }

    //退出;
    @RequestMapping("/out-login.ajax")
    public String OutLogin(HttpServletRequest request){
        //这里没有null这个属性，所以只能是设置setAttribute;
        request.getSession().setAttribute("logined",null);
        JSONObject data = new JSONObject();
        data.put("type",true);
        return data.toJSONString();
    }

    //新增和修改;
    @RequestMapping("/Save-Emp.ajax")
   public String SaveEmp(Integer id, String username, String passwd, String role, String status, String date0) throws Exception {

        //实例化Emp;
        Account0 ac = new Account0();
        ac.setId(id);
        ac.setUsername(username);
        ac.setPasswd(passwd);
        ac.setRole(role);
        ac.setStatus(status);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(date0);
        ac.setDate0(date1);

        int code=0;
        boolean type = as.save(ac);
        if (type){
            code=0;
        }else {
            code=-1;
        }


        //4.以流的形式写出去;
        JSONObject data = new JSONObject();
        data.put("code",code);
        return data.toJSONString();
   }


    //删除;
    @RequestMapping("/Del.ajax")
    public String DelEmp(String ids) {
        //1.定义Object
        JSONObject data = new JSONObject();
        //2.参数校验;
        if (StringUtils.isEmpty(ids)){
            data.put("type",false);
            return data.toJSONString();
        }
        //3.分割数组,遍历;
        String[] idListStr = ids.split(",");
        List<Integer> idList=new ArrayList<>();
//        System.out.println(idList.toString());
        for (String idstr:idListStr){
            int id = Integer.parseInt(idstr);
            idList.add(id);
        }
        //3.1判断是否前端给到参数;
        //System.out.println(idList.toString());
        //4.调用接口;
            as.delete(idList);
        //5.返回数据;
        data.put("type",true);
        return data.toJSONString();
    }

    //锁定
    @RequestMapping("/LockEmp.ajax")
    public String LockEmp(Integer id ) {

        as.LockAccount(id);
        JSONObject data = new JSONObject();
        data.put("type", true);
        return data.toJSONString();
    }

//    public void String (){
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("aa","bb");
//
//    }

 }



