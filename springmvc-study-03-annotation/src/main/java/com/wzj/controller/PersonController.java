package com.wzj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wzj.pojo.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@RestController
public class PersonController {
    @RequestMapping(value = "/json1")
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person("wzj", 3, "男");
        String s = mapper.writeValueAsString(person);
        return s;
    }

    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person p1 = new Person("wzj1",1,"男");
        Person p2 = new Person("wzj2",2,"男");
        Person p3 = new Person("wzj3",3,"男");
        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        String s = objectMapper.writeValueAsString(list);
        return s;
    }

    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        System.out.println(date);
        String s = mapper.writeValueAsString(date);
        System.out.println(s);
        return s;
    }

    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);
        Date date = new Date();
        String s = mapper.writeValueAsString(date);
        return s;
    }


}
