package com.rsn.test.api.qna.dao;

import com.querydsl.core.QueryResults;
import com.rsn.test.api.qna.vo.QnaVO;
import com.rsn.test.config.db.jpa.JpaManager;
import com.rsn.test.config.db.jpa.poms.annotation.PomsJpaManager;
import com.rsn.test.domain.LabelQna;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static com.rsn.test.domain.QLabelQna.labelQna;
import static com.rsn.test.api.qna.spec.QnaSpec.spec;


@Transactional
@RequiredArgsConstructor
@Repository
public class QnaRepository {

    @Autowired @PomsJpaManager
    JpaManager jm;

    public QueryResults<LabelQna> test(QnaVO vo){

        return jm.query.selectFrom(labelQna)
                    .where(
                            spec.lqnTitleEq(vo.getLqnTitle())
                            , spec.lqnContentEq(vo.getLqnContent())
                            , spec.lqnAnswerEq(vo.getLqnAnswer())
                            , labelQna.useYn.like("Y")
                    )
                    .offset(vo.getPageable().getOffset())
                    .limit(vo.getPageable().getPageSize() + 1)
                    .orderBy(spec.getAllOrderSpecifiers(vo.getPageable()))
                    .fetchResults();
    }


    /**
     * QNA 전체 조회
     *  - 페이징
     *  - 검색
     */
    public QueryResults<LabelQna> selectQnaList(QnaVO vo){
        return jm.query.selectFrom(labelQna)
                        .where(
                                spec.lqnTitleEq(vo.getLqnTitle())
                                , spec.lqnContentEq(vo.getLqnContent())
                                , spec.lqnAnswerEq(vo.getLqnAnswer())
                                , labelQna.useYn.like("Y")
                        )
                        .offset(vo.getPageable().getOffset())
                        .limit(vo.getPageable().getPageSize() + 1)
                        .orderBy(spec.getAllOrderSpecifiers(vo.getPageable()))
                        .fetchResults();
    }


    /**
     * QNA 단일 조회
     */
    public LabelQna selectQnaById(Long qnaId){
        return jm.query
                .selectFrom(labelQna)
                .where(
                        labelQna.id.eq(qnaId)
                        , labelQna.useYn.like("Y")
                )
                .fetchOne();
    }

    /**
     * QNA 등록
     */
    public LabelQna insertQna(String lqnTitle, String lqnContent, long regSeq){
        LabelQna x = LabelQna.builder()
                                .lqnTitle(lqnTitle)
                                .lqnContent(lqnContent)
                                .lqnAnswer("")
                                .regSeq(regSeq)
                                .updSeq(regSeq)
                                .regDate(LocalDate.now())
                                .updDate(LocalDate.now())
                                .useYn("Y")
                                .build();
        jm.em.persist(x);
        return x;
    }


    /**
     * QNA 수정
     */
    public long updateQna(Long qnaId, String lqnTitle, String lqnContent){
        return jm.query.update(labelQna)
                    .where(labelQna.id.eq(qnaId))
                    .set(labelQna.lqnTitle, lqnTitle)
                    .set(labelQna.lqnContent, lqnContent)
                    .execute();
    }


    /**
     * QNA 답변 등록/수정
     */
    public long updateQnaLqnAnswer(Long qnaId, String lqnAnswer){
        return jm.query.update(labelQna)
                    .where(labelQna.id.eq(qnaId))
                    .set(labelQna.lqnAnswer, lqnAnswer)
                    .execute();
    }


    /**
     * QNA 삭제
     */
    public long deleteQna(Long qnaId){
        return jm.query
                .update(labelQna)
                .where(labelQna.id.in(qnaId))
                .set(labelQna.useYn, "N")
                .execute();
    }
}
