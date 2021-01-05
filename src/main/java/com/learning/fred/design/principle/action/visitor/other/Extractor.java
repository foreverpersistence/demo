package com.learning.fred.design.principle.action.visitor.other;

public interface Extractor {

    void extract2txt(ResourceFile resourceFile);
}

class PdfExtractor implements Extractor {

    @Override
    public void extract2txt(ResourceFile resourceFile) {

        System.out.println("pdf extract");
    }
}

class PPTExtractor implements Extractor {

    @Override
    public void extract2txt(ResourceFile resourceFile) {

        System.out.println("ppt extract");
    }
}

class WordExtractor implements Extractor {

    @Override
    public void extract2txt(ResourceFile resourceFile) {

        System.out.println("word extract");
    }
}