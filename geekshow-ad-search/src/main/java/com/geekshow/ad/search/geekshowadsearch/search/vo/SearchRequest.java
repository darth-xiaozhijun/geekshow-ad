package com.geekshow.ad.search.geekshowadsearch.search.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {

    //媒体方请求标示
    private String mediaId;

    //请求基本信息
    private RequestInfo requestInfo;

    //匹配信息
    private FeatureInfo featureInfo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestInfo {
        private String requestId;

        private List<AdSlot> adSlots;
        private App app;
        private Geo geo;
        private Device device;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FeatureInfo {

        private KeywordFeature keywordFeature;
        private DistrictFeature districtFeature;
        private HobbyFeatrue hobbyFeatrue;

        private FeatureRelation relation = FeatureRelation.AND;
    }

}
