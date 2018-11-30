package com.wgc.jsonp.exception;

public class DataVlidateException extends Exception {

    public DataVlidateException(){
        super("输出的数据错误");
    }
    public DataVlidateException(String message) {
        super(message);
    }
}
