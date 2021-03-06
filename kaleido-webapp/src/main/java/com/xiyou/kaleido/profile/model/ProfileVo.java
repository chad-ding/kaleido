package com.xiyou.kaleido.profile.model;

import lombok.Data;
import java.util.Date;

/**
 * Created by chad.ding on 2017/1/6.
 */

@Data
public class ProfileVo {
    private String userId;
    private String userName;
    private String realName;
    private String phoneNum;
    private String country;
    private String province;
    private String city;
    private String address;
    private Date birthday;
    private String portrait;
    private char gender;
    private String degree;
    private String occupation;
}
