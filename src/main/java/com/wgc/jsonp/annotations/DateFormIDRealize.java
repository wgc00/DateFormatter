package com.wgc.jsonp.annotations;

import com.wgc.jsonp.date.MyDateFormatter;
import com.wgc.jsonp.entity.PersonMsg;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.HashSet;
import java.util.Set;

//在spring-web.xml中配置就可以使用了
public class DateFormIDRealize implements AnnotationFormatterFactory<DateFormID> {


    @Override
    //注解局限于那个类中
    public Set<Class<?>> getFieldTypes() {
        HashSet<Class<?>> types = new HashSet<>();
        types.add(PersonMsg.class);
        return types;
    }

    @Override
    public Printer<?> getPrinter(DateFormID annotation, Class<?> fieldType) {
        return null;
    }

    @Override
    public Parser<?> getParser(DateFormID annotation, Class<?> fieldType) {
        //把实现类添加过来
        return getMyDateFormatter(annotation);
    }

    private Formatter getMyDateFormatter(DateFormID annotation) {
        //创建一个实现类
        return new MyDateFormatter();
    }
}
