package com.learning.fred.design.principle.pattern.action.visitor;

/**
 * @author fred
 * @date 2021/1/4 13:39
 * @description todo
 */
public class WordFile extends ResourceFile {

    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {

        visitor.visit(this);
    }

//    @Override
//    public void accept(Extractor extractor) {
//
//        extractor.extract2Txt(this);
//    }
}
