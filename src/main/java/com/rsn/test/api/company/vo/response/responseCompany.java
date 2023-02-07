package com.rsn.test.api.company.vo.response;

import com.rsn.test.domain.Company;
import lombok.Data;

@Data
public class responseCompany {

    Long comSeq;
    String comKey;
    String comName;

    public responseCompany(Company vo){
        if(vo == null){
            return;
        }

        this.comSeq = vo.getComSeq();
        this.comKey = vo.getComKey();
        this.comName = vo.getComName();
    }
}
