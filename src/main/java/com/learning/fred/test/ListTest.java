package com.learning.fred.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fred
 * @date 2020/10/16 10:35 上午
 * @description todo
 */
public class ListTest {

    public static void main(String[] args) {

        List<String> s1 = new ArrayList<>();
        s1.add("1");
        s1.add("2");
        s1.add("3");
        List<String> s2 = Arrays.asList("1", "2", "3");

        System.out.println(s1.containsAll(s2));

        s1.add("4");
        System.out.println(s1.containsAll(s2));


//        s1.removeAll(s2);//差集
        s1.retainAll(s2);//交集
        System.out.println(s1);
    }
}
