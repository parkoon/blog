package com.hhwaaaaa1.blog.Entity.com;

import com.hhwaaaaa1.blog.Entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "TB_COM_ROLE")
public class Role extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name = "role_no")
    private long roleNo;

    @Column(name = "role_cd")
    private String roleCd;

    @Column(name = "role_nm")
    private String roleNm;
}
