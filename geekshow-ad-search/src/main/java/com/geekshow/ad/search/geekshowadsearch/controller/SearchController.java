package com.geekshow.ad.search.geekshowadsearch.controller;

import com.alibaba.fastjson.JSON;
import com.geekshow.ad.common.geekshowadcommon.annotation.IgnoreResponseAdvice;
import com.geekshow.ad.common.geekshowadcommon.vo.CommonResponse;
import com.geekshow.ad.search.geekshowadsearch.client.vo.AdPlanGetRequestVO;
import com.geekshow.ad.search.geekshowadsearch.client.vo.AdPlanVO;
import com.geekshow.ad.search.geekshowadsearch.search.vo.SearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/search")
public class SearchController {

    private final RestTemplate restTemplate;

    private final ISearch search;

    @Autowired
    public SearchController(RestTemplate restTemplate, ISearch search) {
        this.restTemplate = restTemplate;
        this.search = search;
    }

    @PostMapping(path = "/plan/get-ribbon")
    @IgnoreResponseAdvice //如果打上这个标记，我们的统一拦截就会忽略掉它
    public CommonResponse<List<AdPlanVO>> getAdPlansUseRibbon(@RequestBody AdPlanGetRequestVO requestVO) {
        log.info("ad-search::getAdPlansUseRibbon -> {}", JSON.toJSONString(requestVO));
        return restTemplate.postForEntity(
                "http://mscx-ad-sponsor/ad-sponsor/plan/get", requestVO, CommonResponse.class
        ).getBody();
    }

    @GetMapping(path = "/user/get")
    public CommonResponse getUsers(@Param(value = "username") String username) {
        log.info("ad-search::getUsers -> {}", JSON.toJSONString(username));
        CommonResponse commonResponse = restTemplate.getForObject(
                "http://mscx-ad-sponsor/ad-sponsor/user/get?username={username}", CommonResponse.class, username
        );

        return commonResponse;
    }

    @PostMapping("/fetchAd")
    public SearchResponse fetchAdCreative(@RequestBody SearchRequest request) {
        log.info("ad-serach: fetchAd ->{}", JSON.toJSONString(request));
        return search.fetchAds(request);
    }

}
