package com.wgc.jsonp.exception;

public class DBException extends Exception{
    public DBException(){
        super("数据库错误");
    }
    public DBException(String message) {
        super(message);
    }
}
