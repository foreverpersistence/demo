package com.learning.fred.design.principle.pattern.action.visitor;

/**
 *  是 资源文件在 功能扩展中不需要进行 修改（添加业务逻辑）
 */
public interface Visitor {

    void visit(PdfFile pdfFile);
    void visit(PPTFile pptFile);
    void visit(WordFile wordFile);
}
