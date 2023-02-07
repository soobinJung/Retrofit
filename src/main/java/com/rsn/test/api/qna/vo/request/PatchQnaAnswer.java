package com.rsn.test.api.qna.vo.request;

import com.rsn.test.api.qna.vo.QnaVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PatchQnaAnswer {
    @NotBlank(message = "lqnAnswer을 입력해주세요.")
    String lqnAnswer;

    public QnaVO toQnaVO(){
        return QnaVO.builder()
                .lqnAnswer(lqnAnswer)
                .build();
    }
}
