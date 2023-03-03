package com.rsn.test.api.qna.controller;

import com.querydsl.core.QueryResults;
import com.rsn.test.api.qna.service.QnaService;
import com.rsn.test.api.qna.vo.LabelQnaDTO;
import com.rsn.test.api.qna.vo.request.GetQna;
import com.rsn.test.api.qna.vo.request.PatchQna;
import com.rsn.test.api.qna.vo.request.PatchQnaAnswer;
import com.rsn.test.api.qna.vo.request.PostQna;
import com.rsn.test.api.qna.vo.response.responseQna;
import com.rsn.test.domain.LabelQna;
import com.rsn.test.error.CustomValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/qna")
public class QnaController {

    private final QnaService qnaService;
    private final CustomValidator validator;


    /**
     * QNA 전체 조회
     *  - 페이징
     *  - 검색
     */
    @GetMapping("")
    public PageImpl selectQnaList(@Validated GetQna qna, BindingResult bindingResult, Pageable pageable){
        validator.check(bindingResult);
        QueryResults<LabelQnaDTO> results = qnaService.selectQnaList(qna.toQnaVO(pageable));
        return new PageImpl<>(
                results.getResults().stream()
                        .map(responseQna::new)
                        .collect(Collectors.toList())
                , pageable
                , results.getTotal()
        );
    }

    /**
     * QNA 단일 조회
     */
    @GetMapping("/{id}")
    public responseQna selectQnaList(@PathVariable("id") int id){
        return new responseQna(qnaService.selectQnaById(Long.valueOf(id)));
    }


    /**
     * QNA 등록
     */
    @PostMapping("")
    public responseQna insertQna(@Validated PostQna qna, BindingResult bindingResult){
        validator.check(bindingResult);
        return new responseQna(qnaService.insertQna(qna.toQnaVO()));
    }

    /**
     * QNA 수정
     */
    @PatchMapping("/{id}")
    public long updateQna(
            @PathVariable("id") int id
            , @Validated PatchQna qna
            , BindingResult bindingResult){
        validator.check(bindingResult);
        return qnaService.updateQna(Long.valueOf(id), qna.toQnaVO());
    }

    /**
     * QNA 수정
     */
    @PatchMapping("/{id}/answer")
    public long updateQnaLqnAnswer(
            @PathVariable("id") int id
            , @Validated PatchQnaAnswer qna, BindingResult bindingResult){
        validator.check(bindingResult);
        return qnaService.updateQnaLqnAnswer(Long.valueOf(id), qna.toQnaVO());
    }

    /**
     * QNA 삭제
     */
    @DeleteMapping("/{id}")
    public long deleteQna(@PathVariable("id") int id){
        return qnaService.deleteQna(Long.valueOf(id));
    }
}
