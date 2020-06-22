package com.tensquare.friend.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "tb_nofriend")
@IdClass(NoFriend.class)
public class NoFriend {

    @Id
    private String userid;

    @Id
    private String feinedid;


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
}

