package com.wgc.jsonp.controller;

import com.wgc.jsonp.annotations.DateFormID;
import com.wgc.jsonp.entity.PersonMsg;
import com.wgc.jsonp.service.PersonMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonMsgController {
    @Autowired
    private PersonMsgService personMsgService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    //如果PersonMsg实体类中没有id字段
    //可以设置@RequestParam(value = "id", required = false)，有就不用设置required
    @RequestMapping(value = "/addid", method = RequestMethod.GET)
    @ResponseBody
    public PersonMsg add(@RequestParam(value = "id", required = false) @DateFormID PersonMsg personMsg ){
        return personMsg;
    }
}
