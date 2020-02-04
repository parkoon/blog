package com.hhwaaaaa1.blog.configurer.security.enumeration;

public enum URL {
    ROOT("/"),

    DEFAULT_LOGIN_FORM_PATH("/auth/login"),
    DEFAULT_FILTER_PROCESSES_URL("/login/processing"),

    H2_URL("/h2-console");


    URL(String value) {
        this.value = value;
    }


    private final String value;


    public String value() {
        return this.value;
    }
}
