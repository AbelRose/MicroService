package com.tensquare.qa.client;

import com.tensquare.qa.client.impl.BaseClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "tensquare-base",fallback = BaseClientImpl.class) // 在这个地方调用各个微服务间的名字 而且不能有下划线
public interface BaseClient {

    //调用 这个base 里面的方法 但是需要改路径
    //这个地方是一个接口
    @RequestMapping(value = "label/{labelId}",method = RequestMethod.GET)//根据API得到根据ID查询的时候 需要加一个value
    public Result findById(@PathVariable("labelId") String labelId); //("labelId") 这个地方必写

}
