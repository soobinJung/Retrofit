package com.rsn.test.config.db.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class PomsConfiguration {

    /**
     * POMS 데이터베이스 정보 세팅
     */
    @Primary
    @Bean("pomsDataSource")
    @ConfigurationProperties(prefix = "spring.poms.hikari")
    public DataSource pomsDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}