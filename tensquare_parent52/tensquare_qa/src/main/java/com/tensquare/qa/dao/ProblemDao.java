package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    //代码生成器生成的是普通的增删改查 没有特定的功能



    //必须写SQl语句了 因为涉及到联查 但是 在这里面默认是使用jpql是面向对象查询的 但是中间表 没有对象
    //一种方法是 创建一个 中间表对象 另一种是直接使用原声的SQL语句 需要设置nativeQuery = true
    //而且还可以用sqlyog 执行一下验证一下看看对不对
    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? ORDER BY replytime DESC ", nativeQuery = true)
    public Page<Problem> newlist(String labelid, Pageable pageable);//需要分页的时候直接加上Pageable pageable就可
    //注意  分页 一定要返回的是 Page


    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? ORDER BY reply DESC ", nativeQuery = true)
    public Page<Problem> hotlist(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid = ? AND reply = 0 ORDER BY createtime DESC ", nativeQuery = true)
	public Page<Problem> waitlist(String labelid, Pageable pageable);
}
