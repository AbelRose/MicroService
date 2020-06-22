package com.tensquare.friend.controller;


import com.tensquare.friend.service.FriendService;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/friend")
public class FriendController {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FriendService friendService;

    /**
     *
     * 添加好友或者非好友
     * @return
     */
    @RequestMapping(value="/like/{friendid}/{type}",method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendid,@PathVariable String type) {

        //验证是否登陆 并且拿到当前用户的id
        Claims claims = (Claims) request.getAttribute("claims_user");
        if (claims == null || "".equals(claims)) {
            return new Result(false, StatusCode.LOGINERROR, "权限不足");
        }
        String userid = claims.getId();
        //判断是添加好友还是添加非好友
        if (type != null) {
            if (type.equals("1")) {
                //添加好友
                int flag = friendService.addFriend(userid, friendid);
                if (flag == 0) {
                    new Result(false, StatusCode.ERROR, "不能重复添加");
                }
                if (flag == 1) {
                    new Result(false, StatusCode.OK, "添加成功");
                }
            } else if (type.equals("2")) {
                //添加非好友
            }
            new Result(false, StatusCode.ERROR, "参数异常");
        } else {
            new Result(false, StatusCode.ERROR, "参数异常");
        }

        return null;
    }

}
