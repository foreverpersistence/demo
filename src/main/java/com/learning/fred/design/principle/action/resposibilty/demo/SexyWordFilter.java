package com.learning.fred.design.principle.action.resposibilty.demo;

/**
 * @author fred
 * @date 2020/12/28 13:57
 * @description 性别 敏感词
 *
 */
public class SexyWordFilter implements SensitiveWordFilter {
    @Override
    public boolean doFileter(Content content) {

        return false;
    }
}
