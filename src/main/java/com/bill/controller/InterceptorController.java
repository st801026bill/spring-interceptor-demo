package com.bill.controller;

import com.bill.interceptor.exceptionhandler.CustomException;
import com.bill.interceptor.exceptionhandler.ReturnCode;
import com.bill.interceptor.requestbodyadvice.CustomRequest;
import com.bill.interceptor.requestbodyadvice.CustomResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {
    @Operation(summary = "Filter", description = "Filter")
    @GetMapping("/filter/demo")
    public void filter() {}

    @Operation(summary = "HandlerInterceptor", description = "HandlerInterceptor")
    @GetMapping("/intercept/demo")
    public void interceptor() {}

    @Operation(summary = "ExceptionHandler", description = "ExceptionHandler")
    @GetMapping("/exception/demo")
    public void exceptionHandler() {
        throw new CustomException(ReturnCode.FAIL);
    }

    @Operation(summary = "RequestBodyAdvice", description = "RequestBodyAdvice")
    @PostMapping("/requestbodyadvice/demo")
    public void requestbodyadvice(@RequestBody CustomRequest request) {}

    @Operation(summary = "ResponseBodyAdvice", description = "ResponseBodyAdvice")
    @PostMapping("/responsebodyadvice/demo")
    public CustomResponse responsebodyadvice(@RequestBody CustomRequest request) {
        return new CustomResponse("data");
    }

}
