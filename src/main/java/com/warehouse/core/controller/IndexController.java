package com.warehouse.core.controller;

import com.warehouse.core.po.Permission;
import com.warehouse.core.service.author.PermissionService;
import com.warehouse.core.vo.NavsVo;
import com.warehouse.core.vo.TreeVo;
import com.warehouse.other.uitls.ConstantUtils;
import com.warehouse.other.uitls.WarehouseUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangding
 * @version V1.0
 * @date 2017/12/28 15:07
 */
@Controller
public class IndexController {


    @Autowired
    PermissionService permissionService;

    @RequestMapping(path = "/index")
    public String home() {
        return "warehouse/index";
    }


    @RequestMapping(path = "/main")
    public String main() {
        return "warehouse/main";
    }

    /**
     * 获取导航菜单
     *
     * @return
     */
    @RequestMapping(path = "/nav")
    @ResponseBody
    public List<NavsVo> nav() {
        List<NavsVo> navsVoList = new ArrayList<>();
        List<Permission> permissionList = permissionService.getPermissionAll();
        for (Permission permission : permissionList) {
            if (permission.getLevel().equals(1L)) {
                NavsVo navsVo = new NavsVo();
                navsVo.setId(permission.getPermissionId());
                navsVo.setHref(permission.getHref());
                navsVo.setIcon(permission.getIcon());
                navsVo.setTitle(permission.getTitle());
                navsVo.setLocationNumber(permission.getLocationNumber());
                if (StringUtils.equals(permission.getSpread(), ConstantUtils.SPREAD_ON)) {
                    navsVo.setSpread(true);
                } else {
                    navsVo.setSpread(false);
                }
                navsVoList.add(navsVo);
            }
        }
        WarehouseUtils.sort(navsVoList, "locationNumber", true);
        for (NavsVo navsVo : navsVoList) {
            List<NavsVo> navsVoChildList = new ArrayList<>();
            for (Permission permission : permissionList) {
                if (permission.getParentPermissionId() != null &&
                        permission.getParentPermissionId().equals(navsVo.getId())) {
                    NavsVo childNavsVo = new NavsVo();
                    childNavsVo.setId(permission.getPermissionId());
                    childNavsVo.setHref(permission.getHref());
                    childNavsVo.setIcon(permission.getIcon());
                    childNavsVo.setTitle(permission.getTitle());
                    childNavsVo.setLocationNumber(permission.getLocationNumber());
                    if (StringUtils.equals(permission.getSpread(), ConstantUtils.SPREAD_ON)) {
                        childNavsVo.setSpread(true);
                    } else {
                        childNavsVo.setSpread(false);
                    }
                    navsVoChildList.add(childNavsVo);
                }
            }
            WarehouseUtils.sort(navsVoChildList, "locationNumber", true);
            navsVo.setChildren(navsVoChildList);
        }
        return navsVoList;
    }


}
