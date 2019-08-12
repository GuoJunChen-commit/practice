package com.chenguojun.demo.configure;

import java.lang.annotation.*;

/**
 * @author cjj
 * @Title: DataSource
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/8/119:46
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    /**
     * 数据源key值
     *
     * @return
     */
    String value();

}
