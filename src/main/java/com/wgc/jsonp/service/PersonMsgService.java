package com.wgc.jsonp.service;

import com.wgc.jsonp.entity.PersonMsg;
import com.wgc.jsonp.exception.IDException;

import java.text.ParseException;

public interface PersonMsgService {

    //分割的方法
    String[] splits(String ID);

    PersonMsg personMsg(String ID) throws IDException, ParseException;

}

