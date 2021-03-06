package com.xiyou.kaleido.user.exception;

import com.xiyou.kaleido.common.exception.ErrorCode;
import lombok.Getter;

/**
 * Created by chad.ding on 2017/1/9.
 */
public enum UserError implements ErrorCode {

    USER_NOT_EXIST(2001, "用户%s不存在"),
    LOGIN_FAILED(2002, "用户%s登录失败,请检查账号密码重新登录"),
    USER_EXISTS(2003, "邮箱账号%s已经注册过");

    @Getter
    private int code;
    @Getter
    private String msg;

    UserError(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
