package com.hhwaaaaa1.blog.enumeration;

public enum PATH {
    DEFAULT_LOGIN_FORM_PATH("/js/react/login/form"),
    DEFAULT_LOGIN_PROCESSES("/js/react/login/submit");


    PATH(String path) {
        this.path = path;
    }


    private final String path;


    public String value() {
        return this.path;
    }
}
