package com.rsn.test.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "DEVEL_LABEL_QNA")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class LabelQna {

    @Id
    @Column(name = "lqn_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lqn_title")
    private String lqnTitle;

    @Column(name = "lqn_content")
    private String lqnContent;

    @Column(name = "lqn_answer")
    private String lqnAnswer;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "reg_seq")
    private Long regSeq;

    @Column(name = "upd_date")
    private LocalDate updDate;

    @Column(name = "upd_seq")
    private Long updSeq;

    @Column(name = "use_yn")
    private String useYn;
}
