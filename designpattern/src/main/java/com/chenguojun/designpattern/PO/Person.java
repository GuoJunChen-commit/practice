package com.chenguojun.designpattern.PO;

import com.chenguojun.designpattern.comparator.PersonComparator;

import java.util.Arrays;

/**
 * @author cjj
 * @Title: Person
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/7/223:15
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    private String reflectMethod(String name) {
        System.out.println("name: " + name);
        return name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person[] people = new Person[]{new Person("zhangsan", 30), new Person("lisi", 25)};
        System.out.println("排序前：");
        for (Person person : people) {
            System.out.println(person.getName() + ":" + person.getAge());
        }
//        Arrays.sort(people);
        Arrays.sort(people, new PersonComparator());
        System.out.println("排序后：");
        for (Person person : people) {
            System.out.println(person.getName() + ":" + person.getAge());
        }
    }
}
