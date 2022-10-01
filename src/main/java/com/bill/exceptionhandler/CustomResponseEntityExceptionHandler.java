package com.bill.exceptionhandler;

import com.bill.InterceptorController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice(assignableTypes = InterceptorController.class)
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, String>> exception(CustomException ex) {
        Map<String, String> result = Map.of(
                "code", ex.getReturnCode().getCode(),
                "message", ex.getReturnCode().getMessage());
        log.info("[ExceptionHandler] CustomResponseEntityExceptionHandler handle result : {}", result);
        return new ResponseEntity< Map<String, String>>(result, HttpStatus.BAD_GATEWAY);
    }
}
