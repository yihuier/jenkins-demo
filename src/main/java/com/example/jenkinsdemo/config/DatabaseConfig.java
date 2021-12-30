package com.example.jenkinsdemo.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author yihuier
 */
@Configuration
@NacosPropertySource(dataId = "dev.properties")
public class DatabaseConfig {
    @NacosValue(value = "${spring.datasource.url}")
    private String url;

    @NacosValue(value = "${spring.datasource.username}")
    private String username;

    @NacosValue(value = "${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
