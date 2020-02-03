package com.hhwaaaaa1.blog.api.entity.mem;

import com.hhwaaaaa1.blog.api.entity.BaseEntity;
import com.hhwaaaaa1.blog.api.entity.com.Role;

import javax.persistence.*;

@Entity
@Table(name = "TM_MEM_USER_ROLE")
@IdClass(value = UserRoleCompositeKey.class)
public class UserRole extends BaseEntity {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_no")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_cd")
    private Role role;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
