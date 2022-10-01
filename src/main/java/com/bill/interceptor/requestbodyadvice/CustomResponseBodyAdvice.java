package com.bill.interceptor.requestbodyadvice;

import com.bill.controller.InterceptorController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@ControllerAdvice(assignableTypes = InterceptorController.class)
public class CustomResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("[ResponseBodyAdvice] CustomResponseBodyAdvice beforeBodyWrite()");
        CustomResponse resp = (CustomResponse)body;
        if(resp == null) return null;

        resp.setData("PREFIX:" + resp.getData());
        return resp;
    }
}
