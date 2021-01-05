package com.learning.fred.design.principle.action.resposibilty.demo;

/**
 * 敏感词的过滤
 */
public interface SensitiveWordFilter {

    boolean doFileter(Content content);
}
