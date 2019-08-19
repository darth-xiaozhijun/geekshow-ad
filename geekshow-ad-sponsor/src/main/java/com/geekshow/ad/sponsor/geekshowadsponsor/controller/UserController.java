package com.geekshow.ad.sponsor.geekshowadsponsor.controller;

import com.alibaba.fastjson.JSON;
import com.geekshow.ad.common.geekshowadcommon.exception.AdException;
import com.geekshow.ad.common.geekshowadcommon.vo.CommonResponse;
import com.geekshow.ad.sponsor.geekshowadsponsor.entity.AdUser;
import com.geekshow.ad.sponsor.geekshowadsponsor.service.IUserService;
import com.geekshow.ad.sponsor.geekshowadsponsor.vo.UserRequestVO;
import com.geekshow.ad.sponsor.geekshowadsponsor.vo.UserResponseVO;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController for 用户controller
 *
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(path = "/create")
    public UserResponseVO createUser(@RequestBody UserRequestVO requestVO) throws AdException {
        log.info("ad-sponsor: createUser -> {}", JSON.toJSONString(requestVO));
        return userService.createUser(requestVO);
    }

    @GetMapping(path = "/get")
    public String getUserList(@Param(value = "username") String username) throws AdException {
        log.info("ad-sponsor: getUserList -> username:{}", JSON.toJSONString(username));
        List<AdUser> allByUserName = userService.findAllByUserName(username);
        log.info("ad-sponsor: getUserList -> allByUserName:{}",JSON.toJSONString(allByUserName));
        CommonResponse commonResponse = new CommonResponse(allByUserName);
        log.info("ad-sponsor: getUserList -> commonResponse:{}",JSON.toJSONString(commonResponse));
        return JSON.toJSONString(new CommonResponse(allByUserName));
    }
}
