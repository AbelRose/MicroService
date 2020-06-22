package com.tensquare.search.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Document(indexName = "tensquare_article",type ="article" )  //注意要添加这个注解 一个对象就对应索引库中的一个文档 第一个是数据库的名称 第二个是表的名称
public class Article implements Serializable { //注意要实现序列化

    @Id
    private String id;








    //是否索引 就是看该域是否能被搜索
    //是否分词 就是看怎么匹配 整体匹配还是单词匹配
    //是否存储 就是是否在页面上显示

    @Field(index = true, analyzer = "ik_max_word",searchAnalyzer = "ik_max_word") //这个Field就对应数据库中的列
    /**
     *
     * 标题 索引 分词 存储    不用索引的就不用加@Field了
     * analyzer = "ik_max_word",searchAnalyzer = "ik_max_word" 存的时候用什么方式存查的时候就用社么方式查
     */
    private String title;  // 这个标题就是网页中的显示出来标题

    @Field(index = true, analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    /**
     *
     * 内容 索引 分词 存储(不一定 如果有简介就不存储) 存储了即写在这里面了
     *
     */
    private String content; // 这个内容就是网页中的显示出来标题








    private String state; //审核状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
