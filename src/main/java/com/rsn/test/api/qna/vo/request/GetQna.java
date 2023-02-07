package com.rsn.test.api.qna.vo.request;

import com.rsn.test.api.qna.vo.QnaVO;
import lombok.*;
import org.springframework.data.domain.Pageable;

@Data
public class GetQna {
    String lqnTitle;
    String lqnContent;
    public QnaVO toQnaVO(Pageable pageable){
        return QnaVO.builder()
                .lqnTitle(lqnTitle)
                .lqnContent(lqnContent)
                .pageable(pageable)
                .build();
    }
}
