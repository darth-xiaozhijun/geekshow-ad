package com.geekshow.ad.search.geekshowadsearch.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 数据请求对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanGetRequestVO {

    private Long userId;
    private List<Long> planIds;
}
