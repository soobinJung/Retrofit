package com.rsn.test.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "TEST_BOARD")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TestBoard{

    @Id
    @Column(name = "test_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testSeq;

    @Column(name = "test_name")
    private String testName;
}
