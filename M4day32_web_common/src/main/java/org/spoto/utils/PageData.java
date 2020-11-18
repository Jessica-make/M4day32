package org.spoto.utils;

import com.alibaba.fastjson.JSONObject;

//这里没有交给spring 管理;
public class PageData {
    //1.默认分页
    private final static Integer DEFAULT_PAGE_SIZE = 5;

    //分页索引
    private Integer PageIndex;
    //每页数量
    private Integer PageSize;
    //搜索数据
    private String sd;

    public PageData() {
    }

    public PageData(Integer pageIndex, Integer pageSize, String sd) {
        PageIndex = pageIndex;
        PageSize = pageSize;
        this.sd = sd;
    }

    public Integer getPageIndex() {
        if (this.PageIndex==null||this.PageIndex<1){
            this.PageIndex=1;
        }
        return PageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        PageIndex = pageIndex;
    }

    public Integer getPageSize() {
        if (this.PageSize==null || this.PageSize < 1){
            this.PageSize=DEFAULT_PAGE_SIZE;
        }
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public JSONObject getSd() {
        if (StringUtils.isNotEmpty(sd)){
            try {
                //所有搜索进入的数据是String 类型，返回值是JSON格式返回;
                //防止黑客，Try-catch;
                JSONObject parse = (JSONObject) JSONObject.parse(this.sd);
                return parse;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "PageIndex=" + PageIndex +
                ", PageSize=" + PageSize +
                ", sd='" + sd + '\'' +
                '}';
    }
}
