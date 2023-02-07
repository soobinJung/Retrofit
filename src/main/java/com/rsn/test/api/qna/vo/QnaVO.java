package com.rsn.test.api.qna.vo;

import com.rsn.test.common.vo.CommonVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class QnaVO extends CommonVO {

    private String lqnContent;
    private String lqnAnswer;
    private String lqnTitle;
}
