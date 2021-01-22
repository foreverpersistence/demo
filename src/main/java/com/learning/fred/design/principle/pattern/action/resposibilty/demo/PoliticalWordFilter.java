package com.learning.fred.design.principle.pattern.action.resposibilty.demo;

/**
 * @author fred
 * @date 2020/12/28 13:57
 * @description 政治敏感词
 */
public class PoliticalWordFilter implements SensitiveWordFilter {
    @Override
    public boolean doFileter(Content content) {
        return false;
    }
}
