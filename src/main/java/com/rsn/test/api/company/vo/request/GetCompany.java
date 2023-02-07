package com.rsn.test.api.company.vo.request;

import com.rsn.test.api.company.vo.CompanyVO;
import lombok.Data;
import org.springframework.data.domain.Pageable;

@Data
public class GetCompany {

    private String comKey;
    private String comName;

    public CompanyVO toCompanyVO(Pageable pageable){
        return CompanyVO.builder()
                .comKey(comKey)
                .comName(comName)
                .pageable(pageable)
                .build();
    }
}
