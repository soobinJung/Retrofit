package com.rsn.test.api.company.dao;

import com.querydsl.core.QueryResults;
import com.rsn.test.api.company.vo.CompanyVO;
import com.rsn.test.config.db.jpa.JpaManager;
import com.rsn.test.config.db.jpa.neo.annotation.NeoJpaManager;
import com.rsn.test.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.rsn.test.domain.QCompany.company;

@Repository
public class CompanyRepository {

    @Autowired @NeoJpaManager
    JpaManager jm;

    /**
     * COMPANY 전체 조회
     *  - 페이징
     *  - 검색
     */
    public QueryResults<Company> selectCompanyList(CompanyVO vo){
        return jm.query.selectFrom(company).fetchResults();
    }
}
