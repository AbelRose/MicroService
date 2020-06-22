package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpitDao extends MongoRepository<Spit,String> {  //注意继承MongoRepository
    //除了增删该查不用自己写之外 分页的时候就需要自己另外写一个了
    public Page<Spit> findByParentid(String parentid, Pageable pageable);
}
