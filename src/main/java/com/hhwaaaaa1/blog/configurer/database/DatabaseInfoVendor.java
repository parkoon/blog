package com.hhwaaaaa1.blog.configurer.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties(value = {
        DatabaseInfoVendor.DataSourceProperties.class,
        DatabaseInfoVendor.JpaProperties.class
})
public class DatabaseInfoVendor {
    public static Logger logger = LoggerFactory.getLogger(DatabaseInfoVendor.class);

    public static class Properties {
        private String driverClassName;
        private String url;
        private String username;
        private String password;
        private String params;


        public String getDriverClassName() {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getParams() {
            return params;
        }

        public void setParams(String params) {
            this.params = params;
        }


        @Override
        public String toString() {
            return "Properties{" +
                    "driverClassName='" + driverClassName + '\'' +
                    ", url='" + url + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", params='" + params + '\'' +
                    '}';
        }
    }


    @ConfigurationProperties(prefix = "spring.datasource")
    public static class DataSourceProperties extends DatabaseInfoVendor.Properties {
        @PostConstruct
        public void postConstruct() {
            DatabaseInfoVendor.logger.debug("get datasource information::::: " + this.toString());
        }
    }

    @ConfigurationProperties(prefix = "spring.jpa")
    public static class JpaProperties {
        public static class Properties {
            public static class Hibernate {
                public static class Hbm2ddl {
                    private String auto;

                    public String getAuto() {
                        return auto;
                    }

                    public void setAuto(String auto) {
                        this.auto = auto;
                    }
                }


                private String dialect;
                private Hbm2ddl hbm2ddl;
                private String showSql;
                private String formatSql;


                public String getDialect() {
                    return dialect;
                }

                public void setDialect(String dialect) {
                    this.dialect = dialect;
                }

                public Hbm2ddl getHbm2ddl() {
                    return hbm2ddl;
                }

                public void setHbm2ddl(Hbm2ddl hbm2ddl) {
                    this.hbm2ddl = hbm2ddl;
                }

                public String getShowSql() {
                    return showSql;
                }

                public void setShowSql(String showSql) {
                    this.showSql = showSql;
                }

                public String getFormatSql() {
                    return formatSql;
                }

                public void setFormatSql(String formatSql) {
                    this.formatSql = formatSql;
                }
            }


            private Hibernate hibernate;


            public Hibernate getHibernate() {
                return hibernate;
            }

            public void setHibernate(Hibernate hibernate) {
                this.hibernate = hibernate;
            }
        }


        private DatabaseInfoVendor.JpaProperties.Properties properties;


        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        @PostConstruct
        public void postConstruct() {
            DatabaseInfoVendor.logger.debug("get jpaProperties information::::: " + this.toString());
        }
    }
}