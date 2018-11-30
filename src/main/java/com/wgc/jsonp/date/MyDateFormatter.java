package com.wgc.jsonp.date;

import com.wgc.jsonp.entity.PersonMsg;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

//实现一个Formatter<T>接口
public class MyDateFormatter implements Formatter<PersonMsg> {

    //返回一个PersonMsg对象
    @Override
    public PersonMsg parse(String text, Locale locale) throws ParseException {
        return new PersonMsg(parsonProvinceID(text), parsonBirthodayID(text), parsonGenderID(text));
    }

    @Override
    public String print(PersonMsg object, Locale locale) {
        return null;
    }

    //获取一个省份
    private String parsonProvinceID(String ID) {
        return map.get(ID.substring(0, 2));
    }

    //获取一个出生日期
    private Date parsonBirthodayID(String ID) throws ParseException {
       return new SimpleDateFormat("yyyyMMdd").parse(ID.substring(6, 14));
    }

    //获取一个性别
    private String parsonGenderID(String ID) {
        return ID.charAt(16) % 2 == 0 ? "女" : "男";
    }

    //在实际的工作中下列的数据是从数据库中调出的
    private static Map<String, String> map = new HashMap<String, String>(){{
        this.put("11","北京市");
        this.put("12","天津市");
        this.put("13","河北省");
        this.put("14","山西省");
        this.put("15","内蒙古自治区");
        this.put("21","辽宁省");
        this.put("22","吉林省");
        this.put("23","黑龙江省");
        this.put("31","上海市");
        this.put("32","江苏省");
        this.put("33","浙江省");
        this.put("34","安徽省");
        this.put("35","福建省");
        this.put("36","江西省");
        this.put("37","山东省");
        this.put("41","河南省");
        this.put("42","湖北省");
        this.put("43","湖南省");
        this.put("44","广东省");
        this.put("45","广西壮族自治区");
        this.put("46","海南省");
        this.put("51","四川省");
        this.put("52","贵州省");
        this.put("53","云南省");
        this.put("54","西藏自治区");
        this.put("50","重庆市");
        this.put("61","陕西省");
        this.put("62","甘肃省");
        this.put("63","青海省");
        this.put("64","宁夏回族自治区");
        this.put("65","新疆维吾尔族自治区");
        this.put("83","台湾地区");
        this.put("81","香港特别行政区");
        this.put("82","澳门特别行政区");
    }};
}
