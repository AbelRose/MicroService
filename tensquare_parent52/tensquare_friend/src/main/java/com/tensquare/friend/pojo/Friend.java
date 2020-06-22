package com.tensquare.friend.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "tb_friend")
@IdClass(Friend.class)
public class Friend {

    @Id
    private String userid;

    @Id
    private String feinedid;

    private String islike;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFeinedid() {
        return feinedid;
    }

    public void setFeinedid(String feinedid) {
        this.feinedid = feinedid;
    }

    public String getIslike() {
        return islike;
    }

    public void setIslike(String islike) {
        this.islike = islike;
    }
}
