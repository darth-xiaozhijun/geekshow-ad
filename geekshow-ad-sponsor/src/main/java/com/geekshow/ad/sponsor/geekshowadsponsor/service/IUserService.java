package com.geekshow.ad.sponsor.geekshowadsponsor.service;

import com.geekshow.ad.common.geekshowadcommon.exception.AdException;
import com.geekshow.ad.sponsor.geekshowadsponsor.entity.AdUser;
import com.geekshow.ad.sponsor.geekshowadsponsor.vo.UserRequestVO;
import com.geekshow.ad.sponsor.geekshowadsponsor.vo.UserResponseVO;

import java.util.List;

public interface IUserService {

    /**
     * 创建用户接口
     *
     * @param userRequestVO {@link UserRequestVO}
     * @return {@link UserResponseVO}
     * @throws AdException 错误
     */
    UserResponseVO createUser(UserRequestVO userRequestVO) throws AdException;

    List<AdUser> findAllByUserName(String userName);

}
