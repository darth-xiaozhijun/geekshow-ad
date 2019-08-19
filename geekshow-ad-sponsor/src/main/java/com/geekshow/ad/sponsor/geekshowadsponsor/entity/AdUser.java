package com.geekshow.ad.sponsor.geekshowadsponsor.entity;

import com.geekshow.ad.sponsor.geekshowadsponsor.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * AdUser for 数据库ad_user表对应的实体类
 * {@link Basic} 标示为数据库的字段信息，如果需要一个不属于数据库的字段，标注为 {@link Transient}
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ad_user")
public class AdUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Basic //不写的话，默认就是@Basic,表示是数据库表的一个字段
    //@Transient //如果打上@Transient 注解，表明当前字段不是表中的字段
    @Column(name = "user_name", nullable = false)
    private String userName;

    @Basic
    @Column(name = "token", nullable = false)
    private String token;

    @Basic
    @Column(name = "user_status", nullable = false)
    private Integer userStatus;

    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Basic
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    /**
     * 创建用户时所需的必填字段
     *
     * @param user_name 用户名称
     * @param token     token
     */
    public AdUser(String user_name, String token) {
        this.userName = user_name;
        this.token = token;
        this.userStatus = CommonStatus.VALID.getStatus();
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}
