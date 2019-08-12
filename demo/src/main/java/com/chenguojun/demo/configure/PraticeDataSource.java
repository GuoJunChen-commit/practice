package com.chenguojun.demo.configure;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cjj
 * @Title: PraticeDataSource
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/8/915:57
 */
@Configuration
@EnableTransactionManagement
//@MapperScan(basePackages = "com.chenguojun.demo.mapper", sqlSessionTemplateRef = "firstSqlSessionTemplate")
@MapperScan(basePackages = "com.chenguojun.demo.mapper")
public class PraticeDataSource {

    @Autowired
    private DataSourceConfig dataSourceConfig;
    @Autowired
    private DataSourceConfig2 dataSourceConfig2;

    //创建数据源
    @Bean(name = "master")
    @Primary
    public DataSource master() {
        DataSource build = DataSourceBuilder.create().driverClassName(dataSourceConfig.getDriverClassName()).url(dataSourceConfig.getUrl()).username(dataSourceConfig.getUsername()).password(dataSourceConfig.getPassword()).build();
        return build;
    }

    //创建数据源
    @Bean(name = "slave")
    public DataSource slave() {
        DataSource build = DataSourceBuilder.create().driverClassName(dataSourceConfig2.getDriverClassName()).url(dataSourceConfig2.getUrl()).username(dataSourceConfig2.getUsername()).password(dataSourceConfig2.getPassword()).build();
        return build;
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("master", master());
        dataSourceMap.put("slave", slave());
        // 将 master 数据源作为默认指定的数据源
        dynamicDataSource.setDefaultDataSource(master());
        // 将 master 和 slave 数据源作为指定的数据源
        dynamicDataSource.setDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource作为数据源则不能实现切换
        sessionFactory.setDataSource(dynamicDataSource());
        sessionFactory.setTypeAliasesPackage("com.chenguojun.demo.pojo.**");    // 扫描Model
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/mapper/**/*.xml";
        sessionFactory.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));   // 扫描映射文件
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // 配置事务管理, 使用事务时在方法头部添加@Transactional注解即可
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}


//    //创建SqlSessionFactory
//    @Bean(name = "firstSqlSessionFactory")
//    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
//        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/mapper/**/*.xml";
//        bean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
//        return bean.getObject();
//    }
//
//    //创建事务管理器
//    @Bean(name = "firstTransactionManager")
//    public DataSourceTransactionManager firstTransactionManager(@Qualifier("firstDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    //创建SqlSessionTemplate
//    @Bean(name = "firstSqlSessionTemplate")
//    public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }



