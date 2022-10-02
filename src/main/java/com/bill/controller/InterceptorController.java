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
    @Operation(summary = "Exception", description = "Exception")
    @GetMapping("/exception/demo")
    public void exception() {
        log.info("[Controller] InterceptorController exception()");
        throw new CustomException(ReturnCode.FAIL);
    }

    @Operation(summary = "Request", description = "Request")
    @PostMapping("/request/demo")
    public CustomResponse request(@RequestBody CustomRequest request) {
        log.info("[Controller] InterceptorController request()");
        return new CustomResponse("data");
//        throw new CustomException(ReturnCode.FAIL);
    }
}
