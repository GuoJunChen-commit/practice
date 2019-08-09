package com.chenguojun.demo.configure;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author cjj
 * @Title: PraticeDataSource
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/8/915:57
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.chenguojun.demo.mapper", sqlSessionTemplateRef = "firstSqlSessionTemplate")
public class PraticeDataSource {

    @Autowired
    private DataSourceConfig dataSourceConfig;

    //创建数据源
    @Bean(name = "firstDataSource")
    public DataSource getFirstDataSource() {
        DataSource build = DataSourceBuilder.create().driverClassName(dataSourceConfig.getDriverClassName()).url(dataSourceConfig.getUrl()).username(dataSourceConfig.getUsername()).password(dataSourceConfig.getPassword()).build();
        return build;
    }

    //创建SqlSessionFactory
    @Bean(name = "firstSqlSessionFactory")
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/mapper/**/*.xml";
        bean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        return bean.getObject();
    }

    //创建事务管理器
    @Bean(name = "firstTransactionManager")
    public DataSourceTransactionManager firstTransactionManager(@Qualifier("firstDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //创建SqlSessionTemplate
    @Bean(name = "firstSqlSessionTemplate")
    public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
