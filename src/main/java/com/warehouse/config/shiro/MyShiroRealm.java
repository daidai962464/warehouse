package com.warehouse.config.shiro;

import com.warehouse.core.po.User;
import com.warehouse.core.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author wangding
 * @version V1.0
 * @date 2017/12/31 17:55
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
    @Resource
    private UserService userService;
//
//    @Resource
//    private ResourcesService resourcesService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //User{id=1, username='admin', password='3ef7164d1f6167cb9f2658c07d3c2f0a', enable=1}
        User user = (User) SecurityUtils.getSubject().getPrincipal();
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("userid", user.getId());
//        List<Resources> resourcesList = resourcesService.loadUserResources(map);
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        for (Resources resources : resourcesList) {
//            info.addStringPermission(resources.getResurl());
//        }
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //获取用户的输入的账号.
        String principal = usernamePasswordToken.getUsername();
        User user = userService.selectByMobile(principal);
        if (user == null) {
            throw new UnknownAccountException();
        }
//        if (0 == user.getEnable()) {
//            throw new LockedAccountException(); // 帐号锁定
//        }

        // 当验证都通过后，把用户信息放在session里
//        Session session = SecurityUtils.getSubject().getSession();
//        session.setAttribute("userSession", user);
//        session.setAttribute("userSessionId", user.getUserId());

//        PasswordHelper.encryptPassword(user);
        return new SimpleAuthenticationInfo(principal, user.getPswd(), getName());
    }


}
