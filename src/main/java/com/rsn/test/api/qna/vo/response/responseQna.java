package com.rsn.test.api.qna.vo.response;

import com.rsn.test.domain.LabelQna;
import lombok.Data;

import java.time.LocalDate;

@Data
public class responseQna {

    Long lqnSeq;
    String lqnTitle;
    String lqnContent;
    String lqnAnswer;
    LocalDate regDate;
    Long regSeq;
    LocalDate updDate;
    Long updSeq;

    public responseQna(LabelQna vo){

        if(vo == null){
            return;
        }

        this.lqnSeq = vo.getId();
        this.lqnTitle = vo.getLqnTitle();
        this.lqnContent = vo.getLqnContent();
        this.lqnAnswer = vo.getLqnAnswer();
        this.regDate = vo.getRegDate();
        this.regSeq = vo.getRegSeq();
        this.updDate = vo.getUpdDate();
        this.updSeq = vo.getUpdSeq();
    }
}
