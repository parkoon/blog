package com.hhwaaaaa1.blog.enums;

public enum JWT {
    PRIVATE_KEY("hhwaaaaa1");


    JWT(String value) {
        this.value = value;
    }

    private final String value;

    public String value() {
        return this.value;
    }
}
