package com.rsn.test.config.retrofit;

import com.rsn.test.api.lucyapi.service.LucyApi;
import okhttp3.OkHttpClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.annotation.PostConstruct;

@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement
public class RetrofitLucyConfig {

    private Retrofit retrofit;

    @PostConstruct
    public void init (){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://lucyapidevel.realsn.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
    }


    @Bean(name = "retrofitLucy")
    public LucyApi retrofitLucy() throws Exception{
        return retrofit.create(LucyApi.class);
    }
}
