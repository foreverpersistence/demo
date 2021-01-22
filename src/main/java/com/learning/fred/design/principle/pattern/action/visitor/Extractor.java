package com.learning.fred.design.principle.pattern.action.visitor;

/**
 * @author fred
 * @date 2021/1/4 13:39
 * @description 转换 重载 函数
 *  1\ 通过实现 统一的 Visitor， 减少 目标资源类的改动
 */
public class Extractor implements Visitor{

//    public void extract2Txt(PPTFile pptFile) {
//        System.out.println("extranct ppt");
//    }
//
//    public void extract2Txt(PdfFile pdfFile) {
//        System.out.println("extranct pdf");
//    }
//    public void extract2Txt(WordFile wordFile) {
//        System.out.println("extranct word");
//    }

    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("extranct pdf");
    }

    @Override
    public void visit(PPTFile pptFile) {
        System.out.println("extranct pdf");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("extranct word");
    }
}
