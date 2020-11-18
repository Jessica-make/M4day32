//package org.spoto.es;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import java.util.Date;
//
////indexName这个数据库的名字
//@Document(indexName = "notes")
//public class Notes {
//
//  @Id
//  private Integer id;
//
//  //FieldType.Text 文字类型;
//  @Field(type= FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
//  private String title;
//
//  @Field(type=FieldType.Date)
//  private Date time;
//
//    public Notes() {
//    }
//
//    public Notes(Integer id, String title, Date time) {
//        this.id = id;
//        this.title = title;
//        this.time = time;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Date getTime() {
//        return time;
//    }
//
//    public void setTime(Date time) {
//        this.time = time;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Notes{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", time=" + time +
//                '}';
//    }
//}
