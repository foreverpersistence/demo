package com.learning.fred.design.principle.action.resposibilty.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fred
 * @date 2020/12/28 13:58
 * @description 符合 GoF 给出的职责链 模式的定义
 */
public class SensitiveWordFilterChain {

    private List<SensitiveWordFilter> filters = new ArrayList<>();

    public void addFilter(SensitiveWordFilter filter) {
        this.filters.add(filter);
    }

    public boolean filter(Content content) {
        for (SensitiveWordFilter filter : filters) {
            if (!filter.doFileter(content)) {
                return false;
            }
        }
        return true;
    }
}
