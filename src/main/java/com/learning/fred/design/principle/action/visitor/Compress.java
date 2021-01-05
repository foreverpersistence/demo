package com.learning.fred.design.principle.action.visitor;

/**
 * @author fred
 * @date 2021/1/4 13:48
 * @description 压缩 功能  重载
 */
public class Compress implements Visitor{

    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("compress pdf");

    }

    @Override
    public void visit(PPTFile pptFile) {
        System.out.println("compress ppt");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("compress word");
    }
}
