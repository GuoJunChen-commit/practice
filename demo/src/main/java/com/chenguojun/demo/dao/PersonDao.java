package com.chenguojun.demo.dao;

import com.chenguojun.demo.pojo.po.PersonPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * (Person)表数据库访问层JPA实现
 *
 * @author chen （具体开发者修改或追加）
 * @since 2019-08-09 16:24:34
 */
@Component
public interface PersonDao extends JpaRepository<PersonPO, Integer> {

}