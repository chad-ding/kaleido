package com.xiyou.kaleido.user.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by chad.ding on 2017/1/10.
 */

@Data
public class UserVo {
    @NotEmpty
    @Size(min=1, max=50)
    private String loginName;
    @NotEmpty
    @Size(min=6, max=50)
    private String loginPassword;
    private char gender;
    private String userId;
    private String userName;
    private String portrait;
    private Date lastLoginTime;
}
