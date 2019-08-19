package com.geekshow.ad.sponsor.geekshowadsponsor.service.impl;

import com.geekshow.ad.common.geekshowadcommon.exception.AdException;
import com.geekshow.ad.common.geekshowadcommon.utils.CommonUtils;
import com.geekshow.ad.sponsor.geekshowadsponsor.constant.Constants;
import com.geekshow.ad.sponsor.geekshowadsponsor.dao.AdUserRepository;
import com.geekshow.ad.sponsor.geekshowadsponsor.entity.AdUser;
import com.geekshow.ad.sponsor.geekshowadsponsor.service.IUserService;
import com.geekshow.ad.sponsor.geekshowadsponsor.vo.UserRequestVO;
import com.geekshow.ad.sponsor.geekshowadsponsor.vo.UserResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserServiceImpl for 用户service
 *
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 创建用户
     *
     * @param userRequestVO {@link UserRequestVO}
     * @return result {@link UserResponseVO}
     */
    @Override
    @Transactional
    public UserResponseVO createUser(UserRequestVO userRequestVO) throws AdException {
        if (!userRequestVO.validate()) {
            log.error("Request params error: {}", userRequestVO);
            throw new AdException(Constants.ErrorMessage.REQUEST_PARAM_ERROR);
        }
        //查重
        AdUser existUser = userRepository.findByUserName(userRequestVO.getUserName());
        if (existUser != null) {
            log.error("{} user is not exist.", userRequestVO.getUserName());
            throw new AdException(Constants.ErrorMessage.USER_EXIST);
        }
        AdUser user = userRepository.save(new AdUser(userRequestVO.getUserName(), CommonUtils.md5(userRequestVO.getUserName())));
        log.info("current user is : {}", user);
        return new UserResponseVO(user.getUserId(), user.getUserName(), user.getToken(),
                user.getCreateTime(), user.getUpdateTime());
    }

    @Override
    public List<AdUser> findAllByUserName(String userName) {
        return userRepository.findAllByUserName(userName);
    }
}
