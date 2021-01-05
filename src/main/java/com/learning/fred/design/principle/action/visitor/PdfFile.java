package com.learning.fred.design.principle.action.visitor;

/**
 * @author fred
 * @date 2021/1/4 13:38
 * @description todo
 */
public class PdfFile extends ResourceFile {

    public PdfFile(String filePath) {
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
