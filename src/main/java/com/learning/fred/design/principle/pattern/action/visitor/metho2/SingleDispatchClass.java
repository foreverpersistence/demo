package com.learning.fred.design.principle.pattern.action.visitor.metho2;

/**
 * @author fred
 * @date 2021/1/5 11:10
 * @description todo
 */
public class SingleDispatchClass {

    public void polymorphismFunction(ParentClass p) {
        p.f();
    }
    public void overloadFunction(ParentClass p) {
//        System.out.println("I am overloadFunction(ParentClass p).");
        p.f();
    }
    public void overloadFunction(ChildClass c) {
//        System.out.println("I am overloadFunction(ChildClass c).");
        c.f();
    }
//
//    I am ChildClass's f().
//    I am overloadFunction(ParentClass p).
}
