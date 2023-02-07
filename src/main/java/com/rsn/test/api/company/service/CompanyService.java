package com.rsn.test.api.company.service;

import com.querydsl.core.QueryResults;
import com.rsn.test.api.company.dao.CompanyRepository;
import com.rsn.test.api.company.vo.CompanyVO;
import com.rsn.test.domain.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public QueryResults<Company> selectCompanyList(CompanyVO vo){
        return companyRepository.selectCompanyList(vo);
    }
}
