package com.hhwaaaaa1.blog.Entity.mem;

import javax.persistence.*;

//@Entity
//@Table(name = "TB_MEM_USER_ROLE")
public class UserRole {
    @ManyToOne
    @JoinColumn(name = "user_no")
    private long userNo;

    @ManyToOne
    @JoinColumn(name = "role_no")
    private long roleNo;


    public long getUserNo() {
        return userNo;
    }

    public void setUserNo(long userNo) {
        this.userNo = userNo;
    }

    public long getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(long roleNo) {
        this.roleNo = roleNo;
    }
}
