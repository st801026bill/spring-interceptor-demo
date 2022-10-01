package com.bill;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {
    @Operation(summary = "Filter", description = "Filter")
    @GetMapping("/filter/demo")
    public void filter() {}

    @Operation(summary = "HandlerInterceptor", description = "HandlerInterceptor")
    @GetMapping("/intercept/demo")
    public void interceptor() {}
}
