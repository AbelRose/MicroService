package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LabelDao extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {

    //这里只提供了最基础的CRUD操作 如果想要进行自定义的操作 需要自己在这里面定义一下
    //使用JPA的时候只需要继承一个JpaRepository，如果是进行复杂的操作 比如分页什么的 要加上JpaSpecificationExecutor

}
