package com.learning.fred.design.principle.pattern.action.visitor.other;


import java.util.ArrayList;
import java.util.List;

/**
 * @author fred
 * @date 2021/1/5 11:05
 * @description todo
 */
public class ToolApplication {

    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
        for (ResourceFile resourceFile : resourceFiles) {
            Extractor extractor = ExtractorFactory.getExtractor(resourceFile.getType());
                    extractor.extract2txt(resourceFile);
        }
    }

    private static List<ResourceFile> listAllResourceFiles(String arg) {
        List<ResourceFile> resourceFiles = new ArrayList<>();

        //  根据文件 创建不同的 对象
        resourceFiles.add(new PdfFile(""));
        resourceFiles.add(new PPTFile(""));
        resourceFiles.add(new WordFile(""));

        return resourceFiles;

    }
}
