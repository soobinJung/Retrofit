package com.rsn.test.error;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

@Slf4j
@Component
public class CustomValidator {

    public void check(BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            String msg = null;
            if (bindingResult.hasErrors()) {
                msg = bindingResult.getFieldErrors()
                        .stream()
                        .map(error -> error.getDefaultMessage())
                        .collect(Collectors.joining(", "));
            }

            if(!StringUtils.isBlank(msg)){
                log.error("검증 실패");
                log.error(msg);
                throw new IllegalArgumentException();
            }
        }
    }
}
