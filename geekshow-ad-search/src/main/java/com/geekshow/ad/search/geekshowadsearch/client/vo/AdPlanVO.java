package com.geekshow.ad.search.geekshowadsearch.client.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * API请求响应结果反序列化对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanVO {

    private Long planId;
    private Long userId;
    private String planName;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;
    private Date createTime;
    private Date updateTime;

}
