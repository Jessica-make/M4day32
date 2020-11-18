package org.spoto.controller;

import com.alibaba.fastjson.JSONObject;

import org.spoto.utils.HttpVisitUtils;
import org.spoto.utils.WechatConf;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class WeChatController {
//    @Resource
//    public EsNotesRep esNotesRep;
//
//    @Resource
//    public EsQu esQu;

    //ElasticSearch搜索
//    @RequestMapping("/es")
//    public EsQuery<Notes> es() {
//        Notes n = new Notes(1, "人人做最好的自己", new Date());
//        Notes n1 = new Notes(2, "人人都是产品经理", new Date());
//        Notes n2 = new Notes(3, "人人日月风华", new Date());
//        Notes n3 = new Notes(4, "人人程序员的自我修养", new Date());
//        Notes n4 = new Notes(5, "人人大国名厨", new Date());
//
//        esNotesRep.save(n);
//        esNotesRep.save(n1);
//        esNotesRep.save(n2);
//        esNotesRep.save(n3);
//        esNotesRep.save(n4);
//
//
//        EsQuery<Notes> query = esQu.query("人人", 1, 10);
//        List<Notes> dataList = query.getDataList();
//        for (Notes data : dataList) {
//            System.out.println(data.toString());
//        }
//        return query;
//    }

    //授权登录
    @RequestMapping("/wechat-login.ajax")
    public JSONObject LoginWechat(@RequestBody JSONObject param){
        //1.接收code和个人信息
        String code = param.getString("code");
        String info = param.getString("info");
        //2.转换JSON格式
        JSONObject userinfo = (JSONObject) JSONObject.parse(info);
        //3.得到用户名和头像
        String nickName = userinfo.getString("nickName");
        String imageInfo = userinfo.getString("avatarUrl");
//       System.out.println(imageInfo);
//       System.out.println(nickName);
        //4.获取微信服务器的url;
        String url = "https://api.weixin.qq.com/sns/jscode2session" +
                "?appid=" + WechatConf.APP_ID + "" +
                "&secret=" + WechatConf.APP_PASSWD + "" +
                "&js_code=" + code +
                "&grant_type=authorization_code";
        //5.拿到String格式openid
        String s = HttpVisitUtils.get(url);
//       System.out.println(s);
        //6.转换JSON格式
        JSONObject parse = (JSONObject) JSONObject.parse(s);
        String openid = parse.getString("openid");

        //7.返回参数;
        JSONObject data = new JSONObject();
        data.put("nickName",nickName);
        data.put("imageInfo",imageInfo);
        return data;
    }




}
