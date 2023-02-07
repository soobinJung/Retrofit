package com.rsn.test.api.company.controller;

import com.querydsl.core.QueryResults;
import com.rsn.test.api.company.dao.CompanyRepository;
import com.rsn.test.api.company.service.CompanyService;
import com.rsn.test.api.company.vo.request.GetCompany;
import com.rsn.test.api.company.vo.response.responseCompany;
import com.rsn.test.api.qna.vo.request.GetQna;
import com.rsn.test.api.qna.vo.response.responseQna;
import com.rsn.test.domain.Company;
import com.rsn.test.domain.LabelQna;
import com.rsn.test.error.CustomValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/company")
public class CompanyController {

    private final CompanyService companyService;
    private final CustomValidator validator;

    /**
     * QNA 전체 조회
     *  - 페이징
     *  - 검색
     */
    @GetMapping("")
    public PageImpl selectCompanyList(@Validated GetCompany company, BindingResult bindingResult, Pageable pageable){
        validator.check(bindingResult);
        QueryResults<Company> results = companyService.selectCompanyList(company.toCompanyVO(pageable));

        return new PageImpl<>(
                results.getResults().stream()
                        .map(responseCompany::new)
                        .collect(Collectors.toList())
                , pageable
                , results.getTotal()
        );
    }
}
