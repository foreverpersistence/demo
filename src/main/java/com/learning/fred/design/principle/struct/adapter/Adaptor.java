package com.learning.fred.design.principle.struct.adapter;

/**
 * @author fred
 * @date 2020/12/22 17:40
 * @description 类适配
 */
public class Adaptor extends Adaptee implements ITarget{

    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {

    }

    @Override
    public void f3() {

    }
}
