package com.learning.fred.design.principle.pattern.action.resposibilty.demo;

/**
 * @author fred
 * @date 2020/12/28 14:00
 * @description todo
 */
public class ApplicationDemo {

    public static void main(String[] args) {
        SensitiveWordFilterChain chain = new SensitiveWordFilterChain();
        chain.addFilter(new SexyWordFilter());
        chain.addFilter(new PoliticalWordFilter());

        boolean legal = chain.filter(new Content());
        if (legal) {
            //发表
        } else {
            //
        }
    }
}
