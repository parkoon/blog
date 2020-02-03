package com.hhwaaaaa1.blog.configurer.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;


public class DatabaseUtility {
    public static Logger logger = LoggerFactory.getLogger(DatabaseUtility.class);

    public static DataSource makeDataSource(DatabaseInfoVendor.Properties properties) {
        return DataSourceBuilder
                .create()
                .driverClassName(properties.getDriverClassName())
                .url(properties.getUrl() + (StringUtils.isEmpty(properties.getParams()) ? "" : "?" + properties.getParams()))
                .username(properties.getUsername())
                .password(properties.getPassword())
                .build();
    }
}