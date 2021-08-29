package com.tanhua.server.test;


import com.tanhua.server.utils.GetAgeUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class DemoTest {
    @Test
    public void demo1(){
        String code = RandomStringUtils.randomNumeric(6);
        System.out.println(code);
        try {
            Date date = new SimpleDateFormat("YYYY-MM-dd").parse("2020-12-25");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo2(){
        int age = GetAgeUtil.getAge("2015-12-10");
        System.out.println(age);
    }




}