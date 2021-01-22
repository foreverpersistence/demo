package com.learning.fred.design.principle.pattern.action.menmeto.v2;

/**
 * @author fred
 * @date 2021/1/5 13:59
 * @description 镜像
 */
public class Snapshot {

    private String text;

    public Snapshot(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
