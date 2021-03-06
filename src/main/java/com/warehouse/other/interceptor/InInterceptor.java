package com.warehouse.other.interceptor;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author wangding
 * @version V1.0
 * @date 2017/11/20 16:18
 */
public class InInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(InInterceptor.class);

    /**
     * 预处理回调方法，实现处理器的预处理（如登录检查）。
     * 第三个参数为响应的处理器，即controller。
     * 返回true，表示继续流程，调用下一个拦截器或者处理器。
     * 返回false，表示流程中断，通过response产生响应。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {


//        String path = request.getContextPath();
//        String basePath = request.getScheme() + "://" + request.getServerName()+ ":" + request.getServerPort() + path + "/";
        logger.info("-------------------"+ request.getRequestURI());
        logger.info("-------------------"+ JSON.toJSONString(request.getParameterMap()) );
//
//        if (request.getHeader("x-requested-with") != null&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
//            response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
//            response.getWriter().print("timeout");
//            response.getWriter().close();
//        }else{
//            response.setContentType("text/html");
//            response.setCharacterEncoding("utf-8");
//            PrintWriter out = response.getWriter();
//            StringBuilder builder = new StringBuilder();
//            builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
//            builder.append("window.location.href =\"" + basePath+ "/login\";");
//            builder.append("</script>");
//            out.print(builder.toString());
//            out.close();
//        }

        return true;
    }

    /**
     * 当前请求进行处理之后，也就是Controller 方法调用之后执行，
     * 但是它会在DispatcherServlet 进行视图返回渲染之前被调用。
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
//        logger.info("-------------------postHandle");
    }

    /**
     * 方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
     * 这个方法的主要作用是用于进行资源清理工作的。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
//        logger.info("-------------------afterCompletion");
    }




}
