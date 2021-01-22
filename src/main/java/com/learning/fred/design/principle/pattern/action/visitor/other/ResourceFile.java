package com.learning.fred.design.principle.pattern.action.visitor.other;

/**
 * @author fred
 * @date 2021/1/5 10:59
 * @description todo
 */
public abstract class ResourceFile {

    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract ResourceFileType getType();
}

class PdfFile extends ResourceFile {
    public PdfFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return null;
    }
}

class WordFile extends ResourceFile {

    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return null;
    }
}

class PPTFile extends ResourceFile {

    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return null;
    }
}
