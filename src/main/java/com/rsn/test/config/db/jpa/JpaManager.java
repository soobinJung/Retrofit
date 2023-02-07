package com.rsn.test.config.db.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class JpaManager {

    public JPAQueryFactory query;
    public EntityManager em;

    public JpaManager( EntityManager em ){
        this.query = new JPAQueryFactory(em);
        this.em = em;
    }
}
