package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FriendDao extends JpaRepository<Friend ,String> {

    //联合主键
    public Friend findByUseridAndFeinedid(String userId,String feinedId);

    @Modifying
    @Query(value = "",nativeQuery = true)
    public void updateIsLike(String islike,String userid,String friendid);
}
