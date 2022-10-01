package com.bill.controller;

import com.bill.interceptor.exceptionhandler.CustomException;
import com.bill.interceptor.exceptionhandler.ReturnCode;
import com.bill.interceptor.requestbodyadvice.CustomRequest;
import com.bill.interceptor.requestbodyadvice.CustomResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class InterceptorController {
    @Operation(summary = "ExceptionHandler", description = "ExceptionHandler")
    @GetMapping("/exception/demo")
    public void exceptionHandler() {
        log.info("[Controller] InterceptorController exceptionHandler()");
        throw new CustomException(ReturnCode.FAIL);
    }

    @Operation(summary = "RequestBodyAdvice", description = "RequestBodyAdvice")
    @PostMapping("/requestbodyadvice/demo")
    public void requestbodyadvice(@RequestBody CustomRequest request) {
        log.info("[Controller] InterceptorController requestbodyadvice()");
//        throw new CustomException(ReturnCode.FAIL);
    }

    @Operation(summary = "ResponseBodyAdvice", description = "ResponseBodyAdvice")
    @PostMapping("/responsebodyadvice/demo")
    public CustomResponse responsebodyadvice(@RequestBody CustomRequest request) {
        log.info("[Controller] InterceptorController responsebodyadvice()");
        return new CustomResponse("data");
    }

}
