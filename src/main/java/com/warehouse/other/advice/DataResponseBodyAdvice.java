package com.warehouse.other.advice;

import com.github.pagehelper.PageInfo;
import com.warehouse.other.uitls.WarehouseUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Type;

/**
 * @author wangding
 * @version V1.0
 * @date 2017/9/13 16:35
 */
@ControllerAdvice
public class DataResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof PageInfo) {
            return WarehouseUtils.getPageVo((PageInfo<?>) body);
        }
        return ReturnFormat.outputJson(0, body);
    }
}
