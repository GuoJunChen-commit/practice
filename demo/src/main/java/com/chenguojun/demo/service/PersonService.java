package com.chenguojun.demo.service;

import com.chenguojun.demo.pojo.po.PersonPO;
import com.chenguojun.demo.pojo.vo.PersonVO;

/**
 * (Person)表服务接口
 *
 * @author chen 修改为具体开发者
 * @since 2019-08-09 16:24:13
 */
public interface PersonService {

    PersonVO getPerson(String id);

    PersonPO save(PersonPO personPO);
}