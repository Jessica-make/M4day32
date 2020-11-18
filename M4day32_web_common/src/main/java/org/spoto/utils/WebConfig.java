//package org.spoto.utils;
////
////import org.springframework.context.annotation.Configuration;
////import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
////import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
////
//////本地图片加载配置，有可能用不了
////@Configuration
////class MyConfigurer implements WebMvcConfigurer {
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/Bookimg/**").addResourceLocations("file:D:\\Bookimg");
////    }
////}
//
//




//package org.spoto.utils;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * 图片绝对地址与虚拟地址映射
// */
//
//@Configuration
// class URLConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //文件磁盘图片url 映射
//        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
//        registry.addResourceHandler("/Bookimg/**").addResourceLocations("file:D://Bookimg");
//        super.addResourceHandlers(registry);
//    }
//}