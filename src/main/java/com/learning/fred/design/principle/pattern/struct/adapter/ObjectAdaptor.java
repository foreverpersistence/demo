package com.learning.fred.design.principle.pattern.struct.adapter;

/**
 * @author fred
 * @date 2020/12/22 17:51
 * @description 对象适配
 */
public class ObjectAdaptor implements ITarget {

    private Adaptee adaptee;

    public ObjectAdaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public void f1() {

        adaptee.fa();
    }

    @Override
    public void f2() {

    }

    @Override
    public void f3() {

    }
}
