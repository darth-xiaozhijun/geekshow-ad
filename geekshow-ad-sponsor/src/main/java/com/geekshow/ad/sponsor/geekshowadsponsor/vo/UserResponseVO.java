package com.geekshow.ad.sponsor.geekshowadsponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * UserResponseVO for 用户响应VO
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseVO {

    private Long userId;
    private String userName;
    private String token;
    private Date createTime;
    private Date updateTime;
}
