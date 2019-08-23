package com.geekshow.ad.search.geekshowadsearch.search;

import com.geekshow.ad.search.geekshowadsearch.search.vo.SearchRequest;
import com.geekshow.ad.search.geekshowadsearch.search.vo.SearchResponse;

/**
 * 根据广告请求对象，获取广告响应信息
 */
public interface ISearch {

    /**
     * 根据请求返回广告结果
     */
    SearchResponse fetchAds(SearchRequest request);

}
