package com.rsn.test.api.lucyapi.controller;

import com.rsn.test.api.lucyapi.service.LucyApiService;
import com.rsn.test.api.lucyapi.vo.LucyResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/lucy-api")
public class LucyAPIController {

    private final LucyApiService lucyApi;

    /**
     * LucyApi 테스트
     */
    @GetMapping("/test")
    public LucyResult selectQnaList() throws IOException {
        return lucyApi.call();
    }
}
