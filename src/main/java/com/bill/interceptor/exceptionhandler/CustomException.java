package com.bill.interceptor.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException{
    ReturnCode returnCode;
    String msg;

    public CustomException(ReturnCode returnCode){
        this.returnCode = returnCode;
    }

    public CustomException(String msg){
        this.msg = msg;
    }
}
