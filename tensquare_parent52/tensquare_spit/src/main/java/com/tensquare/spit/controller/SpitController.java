package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/spit")  //公共的前缀
//@EnableAutoConfiguration
public class SpitController {

    /**
     *
     * Autowired 默认是按照类型注入 如果类型找不到会按照 spitService注入 如果直接想按照名称找的话 需要用到@Qualifier()
     * Resource 是按照名称注入 如果名称找不到会按照类型来找
     *
     */

    @Autowired
    private SpitService spitService;


    //为了控制不能够多次点赞 引入Redis
    @Autowired
//    private RedisTemplate redisTemplate;


    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",spitService.findAll());
    }


    @RequestMapping(value = "/{spitId}" , method = RequestMethod.GET)
    public Result findById(@PathVariable String spitId){
            return new Result(true,StatusCode.OK,"查询成功",spitService.findById(spitId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Spit spit){

        return new Result(true,StatusCode.OK,"保存成功");
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String spitId, @RequestBody Spit spit){

        spit.set_id(spitId);
        spitService.update(spit);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String spitId){

        spitService.delete(spitId);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @RequestMapping(value = "/comment/{parentid}/{page}/{size}", method = RequestMethod.GET)
    public Result findByParentid(@PathVariable String parentid,@PathVariable int page,@PathVariable int size){

        Page<Spit> pageData = spitService.findByParentid(parentid, page, size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Spit>(pageData.getTotalElements(),pageData.getTotalElements()));

    }

    @RequestMapping(value = "/thumbup/{spitId}", method = RequestMethod.PUT)
    public Result findByParentid(@PathVariable String spitId){
//        //判断用户是否点过赞
//        String userid="2023";// 后边我们会修改为当前登陆的用户
//        if(redisTemplate.opsForValue().get("thumbup_"+userid+"_"+
//                id)!=null){
//            return new Result(false,StatusCode.REPERROR,"你已经点过赞了");
//        }
        spitService.thumbup(spitId);
        return new Result(true,StatusCode.OK,"点赞成功");

    }
}
