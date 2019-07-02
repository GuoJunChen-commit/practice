package com.chenguojun.designpattern.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * @author cjj
 * @Title: StartDataListener
 * @ProjectName practice
 * @Description: spring 容器加载完成后执行某个方法
 * @date 2019/7/223:05
 */
@Service
public class StartDataListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("StartDataListener执行。。。。。");
    }
}
