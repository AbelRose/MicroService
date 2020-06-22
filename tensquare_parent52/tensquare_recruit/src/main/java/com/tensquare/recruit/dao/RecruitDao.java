package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
	//推荐
	//findTop6 查找出前6个 相当于 where state = ? order by creatime
	//Desc 表示 最新的在最上面
	public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);

	//where state != ? order by creaetime
	public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);

	//到service里面去
}
