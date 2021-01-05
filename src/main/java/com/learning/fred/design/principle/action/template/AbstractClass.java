package com.learning.fred.design.principle.action.template;

/**
 * @author fred
 * @date 2020/12/25 11:03
 * @description todo
 */
public abstract class AbstractClass {

    //final 防止 重写
    public final void  templateMethond() {

        //可变方法
        method1();
        method2();
    }

    protected abstract void method2();

    protected abstract void method1();
}
