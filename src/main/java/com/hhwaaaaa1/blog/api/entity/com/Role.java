package com.hhwaaaaa1.blog.api.entity.com;

import com.hhwaaaaa1.blog.api.entity.BaseEntity;
import com.hhwaaaaa1.blog.api.entity.mem.UserRole;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_COM_ROLE")
public class Role extends BaseEntity {
    @Id
    @Column(name = "role_cd", length = 50, nullable = false)
    private String roleCd;

    @Column(name = "role_nm", length = 50)
    private String roleNm;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRole;


    public String getRoleCd() {
        return roleCd;
    }

    public Role setRoleCd(String roleCd) {
        this.roleCd = roleCd;
        return this;
    }

    public String getRoleNm() {
        return roleNm;
    }

    public Role setRoleNm(String roleNm) {
        this.roleNm = roleNm;
        return this;
    }
}
