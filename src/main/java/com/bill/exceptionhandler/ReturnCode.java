package com.bill.exceptionhandler;

public enum ReturnCode {

    SUCCESS("0000", "SUCCESS"),
    FAIL("9999", "FAIL");

    private String code;
    private String message;

    ReturnCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {return code;}
    public String getMessage() {return message;}
}
