//package org.spoto.es;
//
//import java.util.List;
//
////分页数据索引,可以直接放到参数类型里面
//public class EsQuery<T> {
//
//    /**
//     * 页面索引
//     */
//    private Integer pageIndex;
//
//    /**
//     * 页面数据条数
//     */
//    private Integer pageSize;
//
//    /**
//     * 总数据条数
//     */
//    private Long dataCount;
//
//    /**
//     * 数据列表
//     */
//    private List<T> dataList;
//
//    public EsQuery() {
//    }
//
//    public EsQuery(Integer pageIndex, Integer pageSize, Long dataCount, List<T> dataList) {
//        this.pageIndex = pageIndex;
//        this.pageSize = pageSize;
//        this.dataCount = dataCount;
//        this.dataList = dataList;
//    }
//
//    public Integer getPageIndex() {
//        return pageIndex;
//    }
//
//    public void setPageIndex(Integer pageIndex) {
//        this.pageIndex = pageIndex;
//    }
//
//    public Integer getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(Integer pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public Long getDataCount() {
//        return dataCount;
//    }
//
//    public void setDataCount(Long dataCount) {
//        this.dataCount = dataCount;
//    }
//
//    public List<T> getDataList() {
//        return dataList;
//    }
//
//    public void setDataList(List<T> dataList) {
//        this.dataList = dataList;
//    }
//
//    @Override
//    public String toString() {
//        return "EsQuery{" +
//                "pageIndex=" + pageIndex +
//                ", pageSize=" + pageSize +
//                ", dataCount=" + dataCount +
//                ", dataList=" + dataList +
//                '}';
//    }
//
//
//
//
//}
