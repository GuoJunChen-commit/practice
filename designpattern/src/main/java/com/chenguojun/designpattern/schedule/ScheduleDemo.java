package com.chenguojun.designpattern.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author cjj
 * @Title: ScheduleDemo
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/7/78:49
 */
@Component
public class ScheduleDemo {
    @Scheduled(initialDelay = 3000, fixedDelay = 6000)
    private void test1() {
        System.out.println("定时任务执行。。。");
    }
}
