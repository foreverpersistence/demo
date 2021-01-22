package com.learning.fred.design.principle.pattern.action.visitor;

/**
 * @author fred
 * @date 2021/1/4 13:38
 * @description todo
 */
public abstract class ResourceFile {

    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    //组合
    //访问开始， 功能添加 Extractor
    abstract public void accept(Visitor visitor);
}
