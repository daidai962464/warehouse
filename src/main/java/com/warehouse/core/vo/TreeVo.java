package com.warehouse.core.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/5 11:15
 */
public class TreeVo implements Serializable {

    private String id;
    private String name;
    private Object object;
    private Long locationNumber;
    private List<TreeVo> children;

    public Long getLocationNumber() {
        return locationNumber;
    }

    public void setLocationNumber(Long locationNumber) {
        this.locationNumber = locationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<TreeVo> getChildren() {
        return children;
    }

    public void setChildren( List<TreeVo> children) {
        this.children = children;
    }
}
