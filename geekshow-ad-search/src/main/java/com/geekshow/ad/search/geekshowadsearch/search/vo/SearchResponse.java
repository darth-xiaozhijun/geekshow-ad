package com.geekshow.ad.search.geekshowadsearch.search.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 检索API响应对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {

    //一个广告位，可以展示多个广告
    //Map key为广告位 AdSlot#adSlotCode
    public Map<String, List<Creative>> adSlotRelationAds = new HashMap<>();

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Creative {

        private Long adId;
        private String adUrl;
        private Integer width;
        private Integer height;
        private Integer type;
        private Integer materialType;

        //展示监控url
        private List<String> showMonitorUrl = Arrays.asList("www.life-runner.com", "www.babydy.cn");
        //点击监控url
        private List<String> clickMonitorUrl = Arrays.asList("www.life-runner.com", "www.babydy.cn");
    }

}
