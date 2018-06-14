package com.warehouse.core.vo;

import java.io.Serializable;

/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/5 11:13
 */
public class SelectVo implements Serializable{

    private String name;
    private String value;
    private String check;

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
