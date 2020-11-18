package org.spoto.utils;

import java.util.List;

//加个泛型，可以给很多集合的对象使用;
public class TableData <T> {
    //第几页;
    private Integer pageIndex;

    //一页几条
    private Integer PageSize;

    //页总数(最大页);
    private Integer pageCount;

    //条总数
    private Integer dataCount;

    //所有数据展示;
    private List<T> dataList;

    public TableData(PageData pd) {
        this.pageIndex=pd.getPageIndex();
        this.PageSize=pd.getPageSize();
    }

    public TableData(PageData pd, Integer pageCount, Integer dataCount, List<T> dataList) {
        this.pageIndex=pd.getPageIndex();
        this.PageSize=pd.getPageSize();
        this.pageCount = pageCount;
        this.dataCount = dataCount;
        this.dataList = dataList;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public Integer getPageCount() {
        Integer lastPage = PageUtils.getLastPage(this.dataCount, this.PageSize);
        this.pageCount=lastPage;
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {

        this.pageCount = pageCount;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }


    @Override
    public String toString() {
        return "TableData{" +
                "pageIndex=" + pageIndex +
                ", PageSize=" + PageSize +
                ", pageCount=" + pageCount +
                ", dataCount=" + dataCount +
                ", dataList=" + dataList +
                '}';
    }




}
