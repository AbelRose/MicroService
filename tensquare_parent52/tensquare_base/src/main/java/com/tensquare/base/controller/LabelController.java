package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.persistence.SqlResultSetMapping;
import java.util.List;
import java.util.Map;

/**
 *
 * controller层 一定要严格参照API来写
 *
 */
@RestController //对象转json //当对象转JSON的时候 不用写responsebody
@CrossOrigin //解决跨域问题
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;//把这个LabelService 注入进去


    @RequestMapping(method = RequestMethod.GET)//根据API得到查询全部的时候 用的是GET方法
    public Result findAll(){

        return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());

    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)//根据API得到根据ID查询的时候 需要加一个value
    public Result findById(@PathVariable("labelId") String labelId){//如果想拿到占位符里面的值 需要用@PathVariable 而且 上下的labelId 要保持一致 如果不一致需要在@PathVariable后加上("labelId")
        return new Result(true,StatusCode.OK,"查询成功",labelService.findById(labelId));

    }
    //JSON 转对象用requestbody

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){ //将页面穿过的json 转换为label //将页面传过来的页面转成了Label
        labelService.save(label);
        return new Result(true,StatusCode.OK,"添加成功");

    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId,@RequestBody Label label){ //将页面穿过的json 转换为label
        label.setId(labelId);
        labelService.update(label);
        return new Result(true,StatusCode.OK,"更新成功");

    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId){ //将页面穿过的json 转换为label
        labelService.deleteById(labelId);
        return new Result(true,StatusCode.OK,"删除成功");

    }
    //在新加一个功能的时候 先写controller 再写service

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label){ //@RequestBody 能把json转换成对象还可以转换成Map(变成一个一个键值对)
        List<Label> list = labelService.findSearch(label);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@RequestBody Label label,@PathVariable int page,@PathVariable int size){ //用@PathVariable int page,@PathVariable int size接收页面的页数和大小 (是为了接收上面穿过来的参数)
        Page<Label> pageData = labelService.pageQuery(label,page,size);//注意分页查询返回的是一个page 不是list
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));//返回时候需要 new PageResult<Label>  第一个参数是总记录数(Long类型) 第二个是当前页中内容<List>
    }


}
