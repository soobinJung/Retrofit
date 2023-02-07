package com.rsn.test.common.vo;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CommonVO {
    private int rowNum;
    private int limitNum;
    String orderByFiled;
    String orderByValue;

    Pageable pageable;
}
