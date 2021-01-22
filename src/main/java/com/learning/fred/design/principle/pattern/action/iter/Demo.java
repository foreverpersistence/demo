package com.learning.fred.design.principle.pattern.action.iter;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author fred
 * @date 2020/12/31 13:41
 * @description todo
 */
public class Demo {

    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//
//        Iterator<String> iterator = list.iterator();
//        Iterator<String> iterator1 = list.iterator();
//        iterator.next();
//        iterator.remove();
//
//        String next = iterator1.next();
//        System.out.println(next);// modCount是  ArrayList的属性


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");

        Iterator<String> iterator2 = linkedList.iterator();
        Iterator<String> iterator3 = linkedList.iterator();

        iterator2.next();
        iterator2.remove();

        String next1 = iterator3.next();
        System.out.println(next1);

    }
}
