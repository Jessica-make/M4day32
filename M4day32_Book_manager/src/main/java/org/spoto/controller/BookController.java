package org.spoto.controller;

import com.alibaba.fastjson.JSONObject;

import org.spoto.dto.BooknameDto;
import org.spoto.model.BookClass;
import org.spoto.model.Bookname;
import org.spoto.service.BookClassService;
import org.spoto.service.LoginService;
import org.spoto.service.impl.BookDtoServiceImpl;
import org.spoto.utils.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.tags.EditorAwareTag;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class BookController {

    @Resource
    private BookClassService bookClassService;

    @Resource
    private LoginService ls;

    @Resource
    private BookDtoServiceImpl dto;
    //登录
    @RequestMapping("/log.ajax")
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

    //给用户名;
    @RequestMapping("/MainList.ajax")
    public String MainList(HttpServletRequest request){
        Object username = request.getSession().getAttribute("logined");
        //1.返回数据;
        JSONObject data = new JSONObject();
        data.put("username",username);
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

    //查询图书分类
    @RequestMapping("/QueryClass.ajax")
    public String QueryBookClass(Integer id) {
       List<BookClass> list = bookClassService.booklist(id);
       JSONObject data = new JSONObject();
       data.put("list", list);
       return data.toJSONString();
     }

    //新增图书
    @RequestMapping("/savebook.ajax")
    public String savebook(String bookclass1, String bookname, MultipartFile bookimage, String author, String introduce,String date0)throws Exception{

        //1.放在最上面,是为了让if里面能够使用
        JSONObject data = new JSONObject();

        if (bookclass1.isEmpty() || bookname.isEmpty() || bookimage.isEmpty() || author.isEmpty() || introduce.isEmpty()|| date0.isEmpty()) {
            data.put("type", false);
            return data.toJSONString();
        } else {
            // 2.获取原始图片的扩展名
            String name = bookimage.getOriginalFilename();
            //3.保存图片到D盘;
            File file = new File("D:\\Bookimg\\"+name);
            //4.Springmvc提供了一种方法,已经封装,直接存到D盘;
            try {
                bookimage.transferTo(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //5.保存图片的地址到数据库
            String path = "d://Bookimg/";
            String imageAdress = path + name;


            //6.调用对象,
            Bookname bok = new Bookname();
            bok.setBookname(bookname);
            bok.setImage(imageAdress);
            bok.setAuthor(author);
            bok.setIntroduce(introduce);
            int bookclass_id = Integer.parseInt(bookclass1);
            bok.setBookclass_id(bookclass_id);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = format.parse(date0);
            bok.setDate(date1);

            //7.调用业务接口,返回数据
            try {
                bookClassService.saveBook(bok);
            }catch (Exception e){
                e.printStackTrace();
            }
            //8.返回数据
            data.put("type", true);
            return data.toJSONString();
        }

    }

    //新增图书分类
    @RequestMapping("/savebookclass.ajax")
    public String bookclass(String bookclass){
        //定义一个状态码;
        int code=0;
        //2.参数校验;
      //isAllNotEmpty 全都不为空;加了！表示有一个是空的;
        if (!StringUtils.isAllNotEmpty(bookclass)){
            //空参数操作;
            code=-1;
        }else {
            boolean saveBookcla = bookClassService.saveBookcla(bookclass);
            if (saveBookcla){
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


    //联表图书展示
    @RequestMapping("/BooknameDto.ajax")
    public String BooknameDto(PageData pd){
        TableData<BooknameDto> booknamebok=null;
        try {
            booknamebok = dto.getBooknamebok(pd);
        }catch (Exception e){
            e.printStackTrace();
        }
        JSONObject data = new JSONObject();
        data.put("booknamebok",booknamebok);
        return data.toJSONString();
    }


    //微信展示图书
    @RequestMapping("/WechatBookshow.ajax")
    public String WeChatBookshow(){
        List<Bookname> dataList = bookClassService.list();
        JSONObject data = new JSONObject();
        data.put("dataList",dataList);
        return data.toJSONString();
    }

    //微信展示第二页单本书数据
    @RequestMapping("/OneBookshow.ajax")
    public JSONObject OneBookshow(@RequestBody JSONObject param){
        //1.接收参数
        String id = param.getString("id");
//        System.out.println(id);

        JSONObject data = new JSONObject();
        //2.参数校验;
//        if (id.isEmpty()){
//            data.put("type",false);
//            return data;
//        }
        //3.参数转换
        int ids = Integer.parseInt(id);
        //4.调用业务接口
        List<Bookname> oneBookList = bookClassService.OneBookList(ids);

        //5.返回参数
//        data.put("type",true);
        data.put("oneBookList",oneBookList);
        return data;
    }




    //前端去D盘拿书的图片(流的形式出去，不需要返回值)
    @RequestMapping("/Bookimg")
    public void BookimgList(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //1.只要发起图书数据请求,里面的name值就可以拿到
        String name = request.getParameter("name");

        //2.这是一个servlet,没有输出流，所以要获取输出流;
        OutputStream os = response.getOutputStream();
        //3.读文件;图片+图片名字;
        FileInputStream fis = new FileInputStream(new File(name));
        //4.图片写到哪里去;
        byte[] b = new byte[1024];
        int num = 0;
        while ((num = fis.read(b)) != -1) {
            os.write(b, 0, num);
        }
        fis.close();
        os.close();
  }

    //删除图书
    @RequestMapping("/DelBook.ajax")
    public String DelBook(String ids) {
        JSONObject data = new JSONObject();
        //1.参数校验
        if (ids.isEmpty()){
           data.put("type",false);
           return data.toJSONString();
        }
        //2.分割数组
        String[] idstrList = ids.split(",");
        //idstrList="8 9 10 11"
        List<Integer> idLists = new ArrayList<>();
        for (String idstr:idstrList){
            Integer id = Integer.parseInt(idstr);
            idLists.add(id);
        }
        //3.调用业务接口
        try {
            bookClassService.delBook(idLists);
        }catch (Exception e){
            e.printStackTrace();
        }
        //4.返回数据
        data.put("type", true);
        return data.toJSONString();

    }



}








