package com.rsn.test.config.db.jpa.neo;

import com.rsn.test.config.db.jpa.JpaManager;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
        entityManagerFactoryRef = "neoEntityManagerFactory"
        , transactionManagerRef = "neoTransactionManager"
)
public class NeoConfiguration {

    @Autowired
    private Environment env;

    /**
     * NEO 데이터베이스 정보 세팅
     */
    @Bean("neoDataSource")
    @ConfigurationProperties(prefix = "spring.neo.hikari")
    public DataSource neoDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    /**
     * neoDataSource 설정을 기반으로 Bean 에 의존성 주입을 설정
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean neoEntityManagerFactory(@Qualifier("neoDataSource") @Autowired DataSource neoDataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(neoDataSource);
        em.setPackagesToScan(new String[] { "com.rsn.test.domain" });
        em.setPersistenceUnitName("NeoPersistence");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }


    /**
     * NeoPersistence 설정을 EntityManager에 주입 후 JpaManager 생성시 전달,
     * NeoJpaManager Bean 등록 후 Annotation 으로 관리.
     */
    @Configuration
    @Qualifier("NeoJpaBeans")
    public static class NeoJpaBeans {
        @PersistenceContext(unitName = "NeoPersistence")
        EntityManager entityManager;

        JpaManager jpaManager;

        @PostConstruct
        public void init(){
            this.jpaManager = new JpaManager(entityManager);
        }

        @Bean(name = "NeoJpaManager")
        public JpaManager jm (){
            return jpaManager;
        }
    }
}


