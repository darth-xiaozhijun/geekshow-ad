package com.geekshow.ad.sponsor.geekshowadsponsor.dao;

import com.geekshow.ad.sponsor.geekshowadsponsor.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * AdUserRepository for 用户数据库操作接口
 * 继承自JpaRepository<AdUser, Long>，第一个参数AdUser代表当前要操作的实体类的class定义，第二个参数Long表示该类的主键类型
 *
 */
public interface AdUserRepository extends JpaRepository<AdUser,Long> {

    /**
     * 根据用户名称获取用户
     *
     * @param username 名称
     * @return 用户对象
     */
    AdUser findByUserName(String username);

    List<AdUser> findAllByUserName(String userName);
}
