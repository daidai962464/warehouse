package com.warehouse.core.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/15 15:10
 */
public class PageVo implements Serializable{

    /**
     * code : 0
     * msg :
     * count : 1000
     * data : []
     */

    private int code;
    private String msg;
    private Long count;
    private List<?> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
