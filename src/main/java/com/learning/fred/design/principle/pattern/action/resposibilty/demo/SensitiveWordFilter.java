package com.learning.fred.design.principle.pattern.action.resposibilty.demo;

/**
 * 敏感词的过滤
 */
public interface SensitiveWordFilter {

    boolean doFileter(Content content);
}
