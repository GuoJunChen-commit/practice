package com.chenguojun.sort;

import com.chenguojun.sort.arrays.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author cjj
 * @Title: ListSort
 * @ProjectName practice
 * @Description: TODO
 * @date 2019/8/820:58
 */
public class ListSort {

    public static void main(String[] args) {
        Person p = new Person(5);
        Person p2 = new Person(10);
        Person p3 = new Person(3);
        Person p4 = new Person(7);
        List<Person> people = new ArrayList<>();
        people.add(p);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        Collections.sort(people);
        System.out.println(people.toString());

        Collections.sort(people, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });

    }


}
