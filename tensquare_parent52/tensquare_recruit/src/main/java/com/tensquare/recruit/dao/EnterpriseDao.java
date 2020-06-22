package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Enterprise;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */

public interface EnterpriseDao extends JpaRepository<Enterprise,String>,JpaSpecificationExecutor<Enterprise>{
	public List<Enterprise> findByIshot(String ishot);  // where ishot = ?  相当于base->LabelService里面的东西 相比之下简化了很多 在此体现了JPA的强大之处
	//然后到service层里面去 public List<Enterprise> hotList

}
