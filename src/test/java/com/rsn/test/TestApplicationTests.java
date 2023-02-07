package com.rsn.test;

import com.rsn.test.api.lucyapi.service.LucyApi;
import com.rsn.test.api.lucyapi.service.LucyApiService;
import com.rsn.test.api.lucyapi.vo.LucyResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	LucyApiService l;

	@Test
	void test() throws IOException {
		LucyResult r = l.call();
		System.out.println(r.getDocs());
	}
}
