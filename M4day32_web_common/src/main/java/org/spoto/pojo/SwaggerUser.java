package org.spoto.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//Apimodel是给生成的文档加一个注释,用不了不知道怎么回事
//不导入丝袜哥架包，怎么用
@ApiModel("用户实体类")
public class SwaggerUser {
    //就是一个名字而已
    @ApiModelProperty("用户名")
    public String username;

    @ApiModelProperty("密码")
    public String passwd;


}
