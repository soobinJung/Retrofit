package com.rsn.test.api.qna.service;

import com.querydsl.core.QueryResults;
import com.rsn.test.api.qna.dao.QnaRepository;
import com.rsn.test.api.qna.vo.QnaVO;
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
    public QueryResults<LabelQna> test(QnaVO vo){
        return qnaRepository.test(vo);
    }

    /**
     * QNA 전체 조회
     *  - 페이징
     *  - 검색
     */
    public QueryResults<LabelQna> selectQnaList(QnaVO vo){
        return qnaRepository.test(vo);
    }

    /**
     * QNA 단일 조회
     */
    public LabelQna selectQnaById(Long qnaId){
        return qnaRepository.selectQnaById(qnaId);
    }

    /**
     * QNA 등록
     */
    public LabelQna insertQna(QnaVO vo){
        long regSeq = 10;
        return qnaRepository.insertQna(
                vo.getLqnTitle()
                , vo.getLqnContent()
                , regSeq
        );
    }

    /**
     * QNA 수정
     */
    public long updateQna(Long qnaId, QnaVO vo){
        return qnaRepository.updateQna(
                qnaId
                , vo.getLqnTitle()
                , vo.getLqnContent()
        );
    }

    /**
     * QNA 답변 등록 / 수정
     */
    public long updateQnaLqnAnswer(Long qnaId, QnaVO vo){
        return qnaRepository.updateQnaLqnAnswer(qnaId, vo.getLqnAnswer());
    }

    /**
     * QNA 삭제
     */
    public long deleteQna(Long qnaId){
        return qnaRepository.deleteQna(qnaId);
    }


}
