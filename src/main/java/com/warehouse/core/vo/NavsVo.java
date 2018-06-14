package com.warehouse.core.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/11 14:59
 */
public class NavsVo implements Serializable {


    /**
     * title : 后台首页
     * icon : icon-computer
     * href : /main
     * spread : false
     * children : [{"title":"权限管理","icon":"&#xe61c;","href":"/permission","spread":false},{"title":"用户管理","icon":"&#xe609;","href":"page/login/login.html","spread":false,"target":"_blank"}]
     */
    private Long id;
    private String title;
    private String icon;
    private String href;
    private boolean spread;
    private Long locationNumber;
    private List<NavsVo> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLocationNumber() {
        return locationNumber;
    }

    public void setLocationNumber(Long locationNumber) {
        this.locationNumber = locationNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<NavsVo> getChildren() {
        return children;
    }

    public void setChildren(List<NavsVo> children) {
        this.children = children;
    }
}
