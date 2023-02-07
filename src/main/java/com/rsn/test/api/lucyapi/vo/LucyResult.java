package com.rsn.test.api.lucyapi.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;

@Data
public class LucyResult {

    @JsonProperty("q")
    String q;

    @JsonProperty("code")
    String code;

    @JsonProperty("docs")
    List<Docs> docs;

    @JsonProperty("numFound")
    String numFound;

    @JsonProperty("start")
    String start;

    @JsonProperty("rows")
    String rows;

    @Data
    public static class Docs{
        @JsonProperty("i_sourcetype")
        String i_sourcetype;

        @JsonProperty("i_profile_img_url")
        String i_profile_img_url;

        @JsonProperty("i_docid")
        String i_docid;

        @JsonProperty("i_p_docid")
        String i_p_docid;

        @JsonProperty("i_sdate")
        String i_sdate;

        @JsonProperty("i_trend")
        String i_trend;

        @JsonProperty("i_sitename")
        String i_sitename;

        @JsonProperty("i_boardname")
        String i_boardname;

        @JsonProperty("cnt")
        String cnt;

        @JsonProperty("i_writer_nick")
        String i_writer_nick;

        @JsonProperty("i_url")
        String i_url;

        @JsonProperty("i_evaluation_index")
        String i_evaluation_index;

        @JsonProperty("s_seq")
        String s_seq;

        @JsonProperty("i_img_url")
        String i_img_url;

        @JsonProperty("i_similar_count")
        String i_similar_count;

        @JsonProperty("i_crawlstamp")
        String i_crawlstamp;

        @JsonProperty("i_content")
        String i_content;

        @JsonProperty("i_title")
        String i_title;

        @JsonProperty("i_writer")
        String i_writer;

    }
}
