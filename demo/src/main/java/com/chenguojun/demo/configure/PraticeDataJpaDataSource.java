package com.chenguojun.demo.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author cjj
 * @Title: PraticeDataJpaDataSource
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/8/921:23
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "jpaEntityManagerFactory",
        transactionManagerRef = "jpaTransactionManager",
        basePackages = "com.chenguojun.demo.dao")
public class PraticeDataJpaDataSource {
    @Autowired
    private DataSource dataSourceConfig;


    @Bean(name = "jpaEntityManager")
    @Primary
    public EntityManager entityManager() {
        return entityManagerFactory().getObject().createEntityManager();
    }


    @Bean(name = "jpaEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter japVendor = new HibernateJpaVendorAdapter();
        japVendor.setGenerateDdl(false);
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSourceConfig);
        entityManagerFactory.setJpaVendorAdapter(japVendor);
        entityManagerFactory.setPackagesToScan("com.chenguojun.demo.pojo.**");//设置实体类所在位置.扫描所有带有 @Entity 注解的类
        return entityManagerFactory;
    }

    @Bean(name = "jpaTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory);
        return manager;
    }

    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceAnnotationBeanPostProcessor();
    }


}
