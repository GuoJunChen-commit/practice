package com.chenguojun.demo.service.impl;

import com.chenguojun.demo.dao.PersonDao;
import com.chenguojun.demo.mapper.PersonMapper;
import com.chenguojun.demo.pojo.po.PersonPO;
import com.chenguojun.demo.pojo.vo.PersonVO;
import com.chenguojun.demo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * (Person)表服务实现类
 *
 * @author chen （具体开发者修改或追加）
 * @since 2019-08-09 16:24:14
 */
@Service
public class PersonServiceImpl implements PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    PersonMapper personMapper;

    @Autowired
    PersonDao personDao;

    @Override
    public PersonVO getPerson(String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        PersonVO personVO = personMapper.getPerson(id);
        return personVO;
    }

    @Override
    public PersonPO save(PersonPO personPO) {
        return personDao.save(personPO);
    }
}