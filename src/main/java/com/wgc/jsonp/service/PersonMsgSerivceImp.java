package com.wgc.jsonp.service;

import com.wgc.jsonp.entity.PersonMsg;
import com.wgc.jsonp.exception.IDException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonMsgSerivceImp implements PersonMsgService {

    //private String IDS = "452113199811241390";
    @Override
    public String[] splits(String ID) {
        String province = ID.substring(0, 2);
        String birthday = ID.substring(6, 10)+ "-" + ID.substring(10, 12) + "-" + ID.substring(12, 14);
        String gander = String.valueOf(ID.charAt(16));
        String[] str = new String[]{province, birthday, gander};
        return str;
    }

    public HashMap<Integer, String> province() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(41, "河南");
        hashMap.put(42, "湖北");
        hashMap.put(43, "湖南");
        hashMap.put(44, "广东");
        hashMap.put(45, "广西");
        return hashMap;
    }

    public PersonMsg personMsg(String ID) throws IDException, ParseException {
        String[] splits = splits(ID);
        String provinces = null;
        String birthdayString = splits[1];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = dateFormat.parse(birthdayString);
       // System.out.println(parse);
        String gander = "男";
        /*获取省份*/
        HashMap<Integer, String> provinceMethod = province();
        for (Map.Entry<Integer, String> e : provinceMethod.entrySet()) {
            if (e.getKey() == Integer.valueOf(splits[0])) {
                provinces = e.getValue();
            }
        }
        /*是男还是女*/
        if (Integer.valueOf(splits[2]) % 2 == 0) {
            gander = "女";
        }
        /*这个身份证是否正确*/
        if (provinces == null && provinces.isEmpty()) {
            throw new IDException();
        }

        return new PersonMsg(provinces, parse, gander);
    }

    /*字符串转为日期*/
}
