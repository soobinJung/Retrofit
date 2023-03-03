package com.rsn.test.api.qna.vo;

import com.rsn.test.common.vo.CommonVO;
import com.rsn.test.domain.LabelQna;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LabelQnaDTO extends CommonVO {

    private Long id;

    private String lqnTitle;

    private String lqnContent;

    private String lqnAnswer;

    private LocalDate regDate;

    private Long regSeq;

    private LocalDate updDate;

    private Long updSeq;

    private String useYn;

    public LabelQnaDTO toLabelQnaDTO(LabelQna q){
        return LabelQnaDTO.builder()
                .id(q.getId())
                .lqnTitle(q.getLqnTitle())
                .lqnContent(q.getLqnContent())
                .lqnAnswer(q.getLqnAnswer())
                .regDate(q.getRegDate())
                .updDate(q.getUpdDate())
                .useYn(q.getUseYn())
                .build();
    }
}
