package com.mmc.security.common.exception.auth;


import com.mmc.security.common.constant.CommonConstants;
import com.mmc.security.common.exception.BaseException;

/**
 * Created by ace on 2017/9/12.
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
