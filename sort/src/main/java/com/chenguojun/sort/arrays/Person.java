package com.chenguojun.sort.arrays;

/**
 * @author cjj
 * @Title: Person
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/8/821:04
 */
public class Person implements Comparable {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            return this.getAge() - p.getAge();
        }
        throw new ClassCastException("传入对象异常");
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
