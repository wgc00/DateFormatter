package com.wgc.jsonp.exception;

public class IDException extends Exception{
    public IDException() {
        super("身份证输出有误，请重新输入！");
    }

    public IDException(String message) {
        super(message);
    }

}
