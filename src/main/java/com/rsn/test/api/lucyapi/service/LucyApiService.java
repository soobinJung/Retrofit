package com.rsn.test.api.lucyapi.service;

import com.rsn.test.api.lucyapi.vo.LucyResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class LucyApiService {

    private final LucyApi service;

    public LucyResult call() throws IOException {

        Call<LucyResult> repos = service.lucyApiCall(
            "68"
            , "2023-01-07"
            , "2023-01-13"
            , "search"
            , "i_evaluation_index,i_sourcetype,i_sdate,i_docid,i_p_docid,i_trend,i_sitename,i_boardname,cnt,i_writer_nick,i_url,s_seq,i_writer_id,i_similar_count,i_crawlstamp,i_content,i_title,i_img_url,i_profile_img_url"
            , "remove"
            , "DN000000010673944613"
            , "sbjung@realsn.com"
        );
        return repos.execute().body();
    }
}