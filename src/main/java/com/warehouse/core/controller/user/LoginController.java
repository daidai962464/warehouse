package com.warehouse.core.controller.user;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.warehouse.core.po.User;
import com.warehouse.core.vo.UserVo;
import com.warehouse.other.interceptor.InInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @author wangding
 * @version V1.0
 * @date 2017/12/28 16:16
 */
@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    DefaultKaptcha defaultKaptcha;


    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(HttpServletResponse response,HttpServletRequest request) {
            Cookie cookie = new Cookie("JSESSIONID", request.getSession().getId());
            cookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String loginOn(HttpServletRequest request, UserVo user) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPwssword())) {
            logger.info("用户名或密码不能为空");
            return "redirect:/login";
        }
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:/login";
        }

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPwssword());
        try {
            subject.login(token);
            return "redirect:/index";
        } catch (LockedAccountException lae) {
            token.clear();
            logger.info("用户已经被锁定不能登录，请与管理员联系！");
            return "redirect:/login";
        } catch (AuthenticationException e) {
            token.clear();
            logger.info("用户或密码不正确！");
            return "redirect:/login";
        }
    }

    @RequestMapping("/checkCode/{time}")
    public void defaultKaptcha(@PathVariable("time") String time, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }


    @RequestMapping(path = "/loginOut", method = RequestMethod.GET)
    public String loginOut() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            // session 会销毁，在SessionListener监听session销毁，清理权限缓存
            subject.logout();
//            if (logger.isDebugEnabled()) {
//                logger.debug("用户" + username + "退出登录");
//        }
        }
        return "redirect:/login";
    }

}
