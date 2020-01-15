package com.hhwaaaaa1.blog.enums;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum UserRole {
    MASTER("ROLE_MASTER"), ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

    UserRole(String roleName){
        this.roleName = roleName;
    }

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isCorrectName(String name){
        return name.equalsIgnoreCase(this.roleName);
    }

    public static UserRole getRoleByName(String roleName){
        return Arrays.stream(UserRole.values()).filter(r->r.isCorrectName(roleName) ).findFirst().orElseThrow(()->new NoSuchElementException("검색된 권한이 없어!"));
    }
}