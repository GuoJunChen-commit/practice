package com.chenguojun.designpattern.ClassLoaderDemo;

import java.text.SimpleDateFormat;

/**
 * @author cjj
 * @Title: MyClassLoader
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/7/321:49
 */
public class MyClassLoader extends ClassLoader {
    private static final ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };

    public static void main(String[] args) {
        Thread thread = new Thread();
        simpleDateFormatThreadLocal.remove();
    }
}
