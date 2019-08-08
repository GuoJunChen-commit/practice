package com.chenguojun.designpattern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author cjj
 * @Title: GetHello
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/7/722:37
 */
@Controller
@RequestMapping("/hello")
public class GetHello {
    @RequestMapping(value = "/haha")
    @ResponseBody
    public String sayHello() {

        List<Object> objects = new ArrayList<>();
        Iterator<Object> iterator = objects.iterator();

        HashSet<Object> objects1 = new HashSet<>();
        objects1.add("");


        return "hello";
    }

}
