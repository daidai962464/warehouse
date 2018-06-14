package com.warehouse.core.controller.user;

import com.github.pagehelper.PageInfo;
import com.warehouse.core.po.Permission;
import com.warehouse.core.po.User;
import com.warehouse.core.service.user.UserService;
import com.warehouse.core.vo.TreeVo;
import com.warehouse.other.uitls.ConstantUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangding
 * @version V1.0
 * @date 2017/12/29 17:59
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/user")
    public String user() {
        return "warehouse/user/userList";
    }


    @RequestMapping(path = "/userList")
    @ResponseBody
    public PageInfo<User> userList(int page, int limit, String jobNumber, String mobile, String email, Long status, String isDel) {
        return userService.getUserList(page, limit, jobNumber, mobile, email, status, isDel);
    }


    @RequestMapping("/userAdd")
    public String userAdd(String type, Model model) {
        model.addAttribute("type", type);
        model.addAttribute("user", new User());
        return "warehouse/user/userEdit";
    }

    @RequestMapping(path = "/userAdd", method = RequestMethod.POST)
    @ResponseBody
    public String userAdd(User user) {
        userService.addUser(user);
        return ConstantUtils.SUCCESS;
    }

}
