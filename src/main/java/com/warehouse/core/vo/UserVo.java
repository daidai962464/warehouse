package com.warehouse.core.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/1 14:55
 */
public class UserVo implements Serializable{

    private String pwssword;
    private String username;

    public String getPwssword() {
        return pwssword;
    }

    public void setPwssword(String pwssword) {
        this.pwssword = pwssword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
