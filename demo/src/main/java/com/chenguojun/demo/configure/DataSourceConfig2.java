package com.chenguojun.demo.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author cjj
 * @Title: DataSourceConfig
 * @ProjectName practice
 * @Description: 数据源配置
 * @date 2019/8/915:50
 */
@Component
@Data
@ConfigurationProperties(prefix = "spring.datasource.mysql.jpa2")
public class DataSourceConfig2 {

    String driverClassName;
    String url;
    String username;
    String password;

}
