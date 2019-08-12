package com.chenguojun.demo.controller;

import com.chenguojun.demo.configure.DataSource;
import com.chenguojun.demo.pojo.po.PersonPO;
import com.chenguojun.demo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Person)表控制层
 *
 * @author chen （具体开发者修改或追加）
 * @since 2019-08-09 16:24:49
 */
@RestController
@RequestMapping("person")
public class PersonController {
    private static final Logger log = LoggerFactory.getLogger(PersonController.class);
    /**
     * service对象
     */
    @Autowired
    private PersonService personService;

    @RequestMapping("/getPerson")
    @DataSource(value = "hahah")
    public PersonPO getPerson(String id) {
//        PersonVO person = personService.getPerson(id);
        PersonPO personVO = personService.getPerson(id);
//        PersonPO personPO = new PersonPO();
//        personPO.setId(Integer.valueOf(id));
//        personPO.setName("lisi");
//
//        PersonPO personPO1 = personService.save(personPO);
        return personVO;
    }

}