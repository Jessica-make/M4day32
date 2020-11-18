package org.spoto.utils;

import com.alibaba.fastjson.JSONObject;

//工具类
public class WebUtils {

    public static String getReturnData(Object obj){

      //第二种写法;
      JSONObject data = (JSONObject) JSONObject.toJSON(obj);
      return data.toJSONString();

    }

}








// TableData<Emp> td = as.list(index, username, passwd);
//
//        List<Emp> dataList = td.getDataList();
//        Integer max = td.getPageCount();
//
//        JSONObject data = new JSONObject();
//        data.put("dataList",dataList);
//        data.put("max",max);
//        return data.toJSONString();