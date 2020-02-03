package com.hhwaaaaa1.blog.api.entity.mem;

import java.io.Serializable;

public class UserRoleCompositeKey implements Serializable {
    public UserRoleCompositeKey(){
    }

    public UserRoleCompositeKey(long userNo, String roleCd){
        this.user = userNo;
        this.role = roleCd;
    }


    private long user;
    private String role;
}
