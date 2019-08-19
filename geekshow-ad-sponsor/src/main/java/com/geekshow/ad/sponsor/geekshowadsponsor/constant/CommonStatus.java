package com.geekshow.ad.sponsor.geekshowadsponsor.constant;

import lombok.Getter;

/**
 * CommonStatus for 通用状态枚举
 *
 * @since 2019/6/15
 */
@Getter
public enum CommonStatus {

    VALID(1, "有效"),
    INVALID(0, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
