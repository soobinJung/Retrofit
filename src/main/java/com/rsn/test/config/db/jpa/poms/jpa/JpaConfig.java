package com.rsn.test.config.db.jpa.poms.jpa;

import com.rsn.test.config.db.jpa.JpaManager;
import com.rsn.test.config.db.config.PomsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
        entityManagerFactoryRef = "pomsEntityManagerFactory"
        , transactionManagerRef = "pomsTransactionManager"
        , basePackages = "com.rsn.test.api.*.dao.*"
)
public class JpaConfig extends PomsConfiguration {

    @Autowired
    private Environment env;

    /**
     * pomsDataSource 설정을 기반으로 Bean 에 의존성 주입을 설정
     */
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean pomsEntityManagerFactory(
            @Qualifier("pomsDataSource") @Autowired DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[] { "com.rsn.test.domain" });
        em.setPersistenceUnitName("PomsPersistence");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }



    /**
     * PomsPersistence 설정을 EntityManager에 주입 후 JpaManager 생성시 전달,
     * PomsJpaManager Bean 등록 후 Annotation 으로 관리.
     */
    @Configuration
    @Qualifier("PomsJpaBeans")
    public static class PomsJpaBeans {
        @PersistenceContext(unitName = "PomsPersistence")
        EntityManager entityManager;
        JpaManager jpaManager;

        @PostConstruct
        public void init(){
            this.jpaManager = new JpaManager(entityManager);
        }

        @Bean(name = "PomsJpaManager")
        public JpaManager jm (){
            return jpaManager;
        }
    }
}
