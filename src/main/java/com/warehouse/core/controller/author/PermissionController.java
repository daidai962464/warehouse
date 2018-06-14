package com.warehouse.core.controller.author;

import com.alibaba.fastjson.JSON;
import com.warehouse.core.po.Permission;
import com.warehouse.core.service.author.PermissionService;
import com.warehouse.core.vo.TreeVo;
import com.warehouse.other.uitls.ConstantUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/3 13:44
 */
@Controller
public class PermissionController {
    private static Logger logger = LoggerFactory.getLogger(PermissionController.class);


    @Autowired
    PermissionService permissionService;

    /**
     * 权限菜单管理
     *
     * @return
     */
    @RequestMapping(path = "/permission")
    public String permission() {
        return "warehouse/author/permissionTree";
    }

    /**
     * 获取tree数据
     *
     * @return
     */
    @RequestMapping(path = "/permissionTree")
    @ResponseBody
    public List<TreeVo> permissionTree() {
        return permissionService.getPermission();
    }


    @RequestMapping(path = "/permissionAdd")
    public String permissionAdd(String type, Model model) {
        model.addAttribute("type", type);
        model.addAttribute("permission", new Permission());
        return "warehouse/author/permissionEdit";
    }

    @RequestMapping(path = "/permissionAdd", method = RequestMethod.POST)
    @ResponseBody
    public String permissionAdd(Permission permission) {
        if (permission.getLevel() == null) {
            permission.setLevel(ConstantUtils.PERMISSION_LEVEL_1);
        }
        if (StringUtils.isBlank(permission.getSpread())) {
            permission.setSpread(ConstantUtils.SPREAD_OFF);
        }
        permissionService.permissionAdd(permission);
        return ConstantUtils.SUCCESS;
    }

    @RequestMapping(path = "/permissionUpdate")
    public String permissionUpdate(String type, Long permissionId, Model model) {
        model.addAttribute("type", type);
        Permission permission = permissionService.getPermissionById(permissionId);
        model.addAttribute("permission", permission);
        return "warehouse/author/permissionEdit";
    }

    @RequestMapping(path = "/permissionUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String permissionUpdate(Permission permission) {
        if (StringUtils.isBlank(permission.getSpread())) {
            permission.setSpread(ConstantUtils.SPREAD_OFF);
        }
        permissionService.permissionUpdate(permission);
        return ConstantUtils.SUCCESS;
    }

    @RequestMapping(path = "/permissionAddChild")
    public String permissionAddChild(String type, Long permissionId, Model model) {
        model.addAttribute("type", type);
        Permission permission = permissionService.getPermissionById(permissionId);
        Permission permissionChild = new Permission();
        permissionChild.setLevel(ConstantUtils.LEVEL_2);
        permissionChild.setParentPermissionId(permission.getPermissionId());
        model.addAttribute("permission", permissionChild);
        return "warehouse/author/permissionEdit";
    }

    @RequestMapping(path = "/permissionDel")
    @ResponseBody
    public String permissionDel(Long permissionId) {
        permissionService.permissionDel(permissionId);
        return ConstantUtils.SUCCESS;
    }

}
