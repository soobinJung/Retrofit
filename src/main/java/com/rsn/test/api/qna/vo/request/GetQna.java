package com.rsn.test.api.qna.vo.request;

import com.rsn.test.api.qna.vo.LabelQnaDTO;
import lombok.*;
import org.springframework.data.domain.Pageable;

@Data
public class GetQna {
    String lqnTitle;
    String lqnContent;
    public LabelQnaDTO toQnaVO(Pageable pageable){
        return LabelQnaDTO.builder()
                .lqnTitle(lqnTitle)
                .lqnContent(lqnContent)
                .pageable(pageable)
                .build();
    }
}
