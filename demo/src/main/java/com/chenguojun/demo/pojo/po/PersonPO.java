package com.chenguojun.demo.pojo.po;

import javax.persistence.*;
import java.io.Serializable;


/**
 * (Person)实体类
 *
 * @author chen
 * @since 2019-08-09 15:45:58
 */
@Entity
@Table(name = "person", schema = "dhlgl", catalog = "")
public class PersonPO implements Serializable {
    private static final long serialVersionUID = 112971969189015167L;
    private Integer id;
    private String name;
    private Integer age;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }


    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}