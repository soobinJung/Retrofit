package com.rsn.test.api.qna.service;

import com.querydsl.core.QueryResults;
import com.rsn.test.api.qna.dao.QnaRepository;
import com.rsn.test.api.qna.vo.LabelQnaDTO;
import com.rsn.test.domain.LabelQna;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QnaService {

    private final QnaRepository qnaRepository;

    /**
     * QNA 전체 조회
     *  - 페이징
     *  - 검색
     */
    public QueryResults<LabelQnaDTO> selectQnaList(LabelQnaDTO vo){
        return qnaRepository.selectQnaList(vo);
    }

    /**
     * QNA 단일 조회
     */
    public LabelQnaDTO selectQnaById(Long qnaId){
        return qnaRepository.selectQnaById(qnaId);
    }

    /**
     * QNA 등록
     */
    public LabelQnaDTO insertQna(LabelQnaDTO vo){
        long regSeq = 10;
        return new LabelQnaDTO().toLabelQnaDTO(
                qnaRepository.insertQna(
                        vo.getLqnTitle()
                        , vo.getLqnContent()
                        , regSeq
                )
        );
    }

    /**
     * QNA 수정
     */
    public long updateQna(Long qnaId, LabelQnaDTO vo){
        return qnaRepository.updateQna(
                qnaId
                , vo.getLqnTitle()
                , vo.getLqnContent()
        );
    }

    /**
     * QNA 답변 등록 / 수정
     */
    public long updateQnaLqnAnswer(Long qnaId, LabelQnaDTO vo){
        return qnaRepository.updateQnaLqnAnswer(qnaId, vo.getLqnAnswer());
    }

    /**
     * QNA 삭제
     */
    public long deleteQna(Long qnaId){
        return qnaRepository.deleteQna(qnaId);
    }


}
