package com.chenguojun.demo.mapper;


import com.chenguojun.demo.pojo.vo.PersonVO;
import org.apache.ibatis.annotations.Mapper;


/**
 * (Person)表数据库访问层Mybatis实现
 *
 * @author chen （具体开发者修改或追加）
 * @since 2019-08-09 16:23:07
 */
@Mapper
public interface PersonMapper {

    PersonVO getPerson(String map);
}