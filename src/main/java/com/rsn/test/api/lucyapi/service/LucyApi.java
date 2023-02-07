package com.rsn.test.api.lucyapi.service;

import com.rsn.test.api.lucyapi.vo.LucyResult;
import com.rsn.test.config.retrofit.RetrofitLucy;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@RetrofitLucy
public interface LucyApi {

    @GET("API")
    Call<LucyResult> lucyApiCall(
        @Query("systemkey") String systemkey
        , @Query("i_sdate") String i_sdate
        , @Query("i_edate") String i_edate
        , @Query("cmd") String cmd
        , @Query("fieldList") String fieldList
        , @Query("i_spam_search_type") String i_spam_search_type
        , @Query("i_docid") String i_docid
        , @Query("userid") String userid
    );
}
