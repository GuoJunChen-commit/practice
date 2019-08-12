package com.chenguojun.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    int value = 20;

    @Test
    public void contextLoads() {
        int value = 10;
        System.out.println(this.value);

    }

}
