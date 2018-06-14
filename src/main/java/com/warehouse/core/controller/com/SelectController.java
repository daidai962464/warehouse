package com.warehouse.core.controller.com;

import com.alibaba.fastjson.JSON;
import com.warehouse.core.po.Permission;
import com.warehouse.core.service.author.PermissionService;
import com.warehouse.core.vo.SelectVo;
import com.warehouse.other.uitls.ConstantUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/5 11:19
 */
@Controller
public class SelectController {


    @Autowired
    PermissionService permissionService;


    @RequestMapping(path = "/permissionLocationNumber", method = RequestMethod.GET)
    @ResponseBody
    public List<SelectVo> permissionLocationNumber( Long permissionId,
                                                    Long parentPermissionId,
                                                   Long level) {
       return   permissionService.permissionLocationNumber(permissionId,parentPermissionId, level);
    }
}
