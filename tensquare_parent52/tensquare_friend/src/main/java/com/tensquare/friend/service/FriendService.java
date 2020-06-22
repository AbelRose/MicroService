package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    public int addFriend(String userid, String friendid) {
        //先判断user->friend 方向type是否有数据 返回0
        Friend friend = friendDao.findByUseridAndFeinedid(userid, friendid);
        if(friend != null){
            return 0;
        }
        //直接添加好友 让user->friend 方向type为0-
        friend = new Friend();
        friend.setUserid(userid);
        friend.setFeinedid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);

        //friend->user 如果有双放都该成1
        if( friendDao.findByUseridAndFeinedid(friendid,userid)!=null){

        }
        return 0;
    }
}
