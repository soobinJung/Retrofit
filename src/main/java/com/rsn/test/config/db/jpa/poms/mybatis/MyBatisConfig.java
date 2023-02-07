package com.rsn.test.config.db.jpa.poms.mybatis;

import com.rsn.test.config.db.jpa.poms.PomsConfiguration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MyBatisConfig extends PomsConfiguration {

    @Bean(name = "pomsSqlSessionFactory")
    public SqlSessionFactory pomsSqlSessionFactory(@Autowired @Qualifier("pomsDataSource") DataSource pomsDataSource,
                                                   ApplicationContext applicationContext) throws Exception{

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(pomsDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/poms/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "pomsSqlSession")
    public SqlSession pomsSqlSession(@Autowired @Qualifier("pomsSqlSessionFactory") SqlSessionFactory pomsSqlSessionFactory) throws Exception{

        return new SqlSessionTemplate(pomsSqlSessionFactory);
    }
}
