package com.geekshow.ad.sponsor.geekshowadsponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * UserRequestVO for 创建用户请求对象VO
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestVO {

    private String userName;

    public boolean validate() {
        return !StringUtils.isEmpty(userName);
    }
}
