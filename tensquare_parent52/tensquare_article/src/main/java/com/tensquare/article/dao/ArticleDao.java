package com.tensquare.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{


    @Modifying //增删改必须加上的东西 查询的时候只加上下面的@Query就可
    @Query(value = "UPDATE tb_article SET state = 1 WHERE id = ?", nativeQuery = true) //注意S此时QL语句不能有分号
    public void updateState(String id);

    @Modifying //增删改必须加上的东西
    @Query(value = "UPDATE tb_article SET thumbup = thumbup+1 WHERE id = ?", nativeQuery = true) //注意如果是null的话 null+1还是null 做算术运算全是null
    public void addThumbup(String id);


}
