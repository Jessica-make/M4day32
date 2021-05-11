//package org.spoto.config;
//
//import org.spoto.controller.HelloController;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.core.env.Profiles;
//import org.springframework.web.bind.annotation.RestController;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.lang.annotation.Annotation;
//import java.util.ArrayList;
//
//@Configuration
//@EnableSwagger2//开启Swagger2
//public class SwaggerConfig {
//    //配置多个分组
//    @Bean
//    public Docket docket1(){
//
//        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
//    }
//
//    @Bean
//    public Docket docket2(){
//
//        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
//    }
//
//    @Bean
//    public Docket docket3(){
//
//        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
//    }
//    @Bean
//    public Docket docket4(){
//
//        return new Docket(DocumentationType.SWAGGER_2).groupName("D");
//    }
//
//
//    //Docket,是swagger提供的唯一的一个对象
//
//    //配置了swgger的bean实例
//    @Bean
//    public Docket docket(Environment environment ){
//        //of是个数组，代表可以传多个
//        Profiles profiles=Profiles.of("dev","test");
//
//        //获得一个激活的环境; acceptsProfiles判定是否可以处在自己设定的环境中;
//        boolean flag = environment.acceptsProfiles(profiles);
//
//
//        //(DocumentationType.SWAGGER_2)表示原来的信息
//        //apiInfo(apiInfo()表示修改以后的信息
//        return new Docket(DocumentationType.SWAGGER_2).
//                apiInfo(apiInfo()).
//                //搜索的名字
//                groupName("龙哥").
//                //enable 是否启动swagger 默认是启动
//                enable(true).
//                select().
//                //RequestHandlerSelectors 配置要扫描接口的方式
//                        //basePackage 基于哪个包  any()扫描全部  //none都不扫描
//                                //withClassAnnotation(RestController.class) 扫描带有RestController的类
//                apis(RequestHandlerSelectors.basePackage("org.spoto.controller")).
//                //paths 过滤掉哪些路径
////                paths(PathSelectors.ant("/com/**")).
//                build()
//                ;
//    }
//
//    //ApiInfo,是Docket下面的方法
//    //配置Swgger信息=apiInfo
//    private ApiInfo apiInfo(){
//       //作者信息
//       Contact contact= new Contact("赵江龙", "https://www.baidu.com/", "1164185650@qq.com");
//
//
//        return  new ApiInfo("赵江龙的Swagger学习",
//                "坚持就是胜利!",
//                "1.0",
//                "https://www.baidu.com/", contact,
//                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
//                //默认的，是一个空的
//                new ArrayList());
//
//    }
//
//
//}
