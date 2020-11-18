package org.spoto.utils;

import org.apache.ibatis.session.RowBounds;

public class PageUtils {
    /**
     *  取多少页;
     * @param dataCount 总条数
     * @param PageSize  一页几条
     * @return 最大页;
     */
   public static Integer getLastPage(Integer dataCount ,Integer  PageSize){
       if (dataCount % PageSize==0){
           return  dataCount/PageSize;
       }else {
           return  (dataCount/PageSize)+1;
       }
    }

    /**
     *
     * @param pd  分数页
     * @return rb
     */
    public static RowBounds getRowBounds(PageData pd){
        Integer pageIndex=pd.getPageIndex();
        Integer PageSize=pd.getPageSize();

        int offset=(pageIndex-1) *PageSize;
        int limit=PageSize;
        RowBounds rb = new RowBounds(offset,limit);
        return rb;
    }

}
