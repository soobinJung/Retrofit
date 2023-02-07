package com.rsn.test.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "COMPANY_TEST")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Company {

    @Id
    @Column(name = "com_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comSeq;

    @Column(name = "com_key")
    private String comKey;

    @Column(name = "com_name")
    private String comName;
}
