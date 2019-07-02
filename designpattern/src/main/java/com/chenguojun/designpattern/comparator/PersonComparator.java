package com.chenguojun.designpattern.comparator;

import com.chenguojun.designpattern.PO.Person;

import java.util.Comparator;

/**
 * @author cjj
 * @Title: PersonComparator
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/7/223:28
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
