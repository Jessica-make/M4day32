//package org.spoto.es;
//
//
//import com.alibaba.fastjson.JSONObject;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.SearchHits;
//import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
//import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.SearchResultMapper;
//import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
//import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.data.elasticsearch.core.query.SearchQuery;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
////这个工具类是为了给搜索结果加颜色
//@Component
//public class EsQu {
//
//   @Resource
//   private ElasticsearchTemplate elasticsearchTemplate;
//
//    /**
//     * 高亮查询
//     *
//     * @param keyWord   关键字
//     * @param pageIndex 分页索引
//     * @param pageSize  分页条数
//     * @return 结果
//     */
//    public EsQuery<Notes> query(String keyWord, Integer pageIndex, Integer pageSize) {
//        // 定义高亮规则
//        String preTags = "<span class=\"search-select\">";
//        String postTags = "</span>";
//        //可以搜索标题和内容,加txt
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
//                .should(QueryBuilders.matchQuery("title", keyWord)
//                );
//        // 设置分页(页面索引, 一页条数)
//        Pageable page = PageRequest.of(pageIndex - 1, pageSize);
//
//        // 构建查询
//        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(boolQueryBuilder)
//                // 设置高亮字段和规则
//                //可以高亮标题和内容,加txt
//                .withHighlightFields(
//                        new HighlightBuilder.Field("title").preTags(preTags).postTags(postTags)
//                )
//                .withPageable(page).build();
//        // 高亮搜索数据
//        AggregatedPage<Notes> dl = elasticsearchTemplate.queryForPage(searchQuery, Notes.class,
//                new SearchResultMapper() {
//
//                    /**
//                     * 搜索结果处理
//                     *
//                     * @param response 搜索结果
//                     * @param c        结果类型
//                     * @param pageable 分页条件
//                     * @return 搜索结果
//                     */
//                    @Override
//                    public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> c, Pageable pageable) {
//                        // 搜索结果
//                        SearchHits searchHits = response.getHits();
//                        if (searchHits == null || searchHits.getHits().length <= 0) {
//                            return null;
//                        }
//                        // 定义高亮字段
//                        String[] hitFields = { "title" };
//                        // 最终结果
//                        List<T> result = new ArrayList<T>();
//                        for (SearchHit searchHit : searchHits) {
//                            // 获取单条结果
//                            Map<String, Object> data = searchHit.getSourceAsMap();
//                            // 处理高亮字段
//                            for (String hitField : hitFields) {
//                                HighlightField highlightField = searchHit.getHighlightFields().get(hitField);
//                                if (highlightField != null) {
//                                    data.remove(hitField);
//                                    data.put(hitField, highlightField.fragments()[0].toString());
//                                }
//                            }
//                            T t = JSONObject.toJavaObject((JSONObject) JSONObject.toJSON(data), c);
//                            result.add(t);
//                        }
//                        if (result.isEmpty()) {
//                            return null;
//                        } else {
//                            // 结果封装
//                            return new AggregatedPageImpl<>(result, pageable, searchHits.getTotalHits());
//                        }
//                    }
//
//                    /**
//                     * 高亮处理
//                     */
//                    @Override
//                    public <T> T mapSearchHit(SearchHit searchHit, Class<T> type) {
//                        return null;
//                    }
//                });
//        return this.doResult(dl, pageIndex, pageSize);
//    }
//
//    /**
//     * 搜索结果封装
//     *
//     * @param dl        搜索结果
//     * @param pageIndex 分页索引
//     * @param pageSize  分页条数
//     * @return 结果
//     */
//    private EsQuery<Notes> doResult(AggregatedPage<Notes> dl, Integer pageIndex,
//                                    Integer pageSize) {
//        if (dl != null) {
//            Iterator<Notes> iterator = dl.iterator();
//            List<Notes> earl = new ArrayList<Notes>();
//            while (iterator.hasNext()) {
//                Notes eai = iterator.next();
//                earl.add(eai);
//            }
//            EsQuery<Notes> eqr = new EsQuery<Notes>();
//            eqr.setPageIndex(pageIndex);
//            eqr.setPageSize(pageSize);
//            eqr.setDataCount(dl.getTotalElements());
//            eqr.setDataList(earl);
//            return eqr;
//        } else {
//            return null;
//        }
//    }
//
//
//
//}
