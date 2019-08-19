package com.geekshow.ad.common.geekshowadcommon.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * CommonUtils for 工具类
 *
 */
@Slf4j
public class CommonUtils {

    /**
     * md5 加密
     */
    public static String md5(String value) {
        return DigestUtils.md5Hex(value).toUpperCase();
    }
}
