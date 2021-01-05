package com.learning.fred.design.principle.action.template.call;

/**
 * @author fred
 * @date 2020/12/25 11:22
 * @description todo
 */
public class AClass {

    public static void main(String[] args) {

        BClass b= new BClass();
        b.process(new ICallback() {//回调对象
            @Override
            public void methodToCallback() {
                //
                System.out.println("callback...");
            }
        });
    }
}
