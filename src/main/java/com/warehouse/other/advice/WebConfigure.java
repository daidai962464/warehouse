package com.warehouse.other.advice;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wangding
 * @version V1.0
 * @date 2017/9/13 16:23
 * @
 */
@Configuration
public class WebConfigure extends WebMvcConfigurerAdapter {

    @Bean
    public HttpMessageConverters useConverters() {

        return new HttpMessageConverters(new FastJsonHttpMessageConverter());
    }
}