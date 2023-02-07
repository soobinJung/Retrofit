package com.rsn.test.api.company.vo;

import com.rsn.test.common.vo.CommonVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyVO extends CommonVO {

    private String comKey;
    private String comName;
}
