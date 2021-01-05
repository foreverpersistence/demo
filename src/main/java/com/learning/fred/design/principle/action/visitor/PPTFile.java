package com.learning.fred.design.principle.action.visitor;

/**
 * @author fred
 * @date 2021/1/4 13:39
 * @description todo
 */
public class PPTFile extends ResourceFile {

    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {

        visitor.visit(this);
    }

//    @Override
//    public void accept(Extractor extractor) {
//        extractor.extract2Txt(this);
//    }
}
