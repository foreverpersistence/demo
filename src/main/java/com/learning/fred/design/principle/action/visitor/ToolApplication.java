package com.learning.fred.design.principle.action.visitor;

import ch.qos.logback.core.rolling.helper.Compressor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fred
 * @date 2021/1/4 13:40
 * @description todo
 */
public class ToolApplication {

    public static void main(String[] args) {
        Extractor extractor = new Extractor();
//        List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
//        for (ResourceFile resourceFile : resourceFiles) {
////            extractor.extract2txt(resourceFile);
//            resourceFile.accept(extractor);//visitor
//        }

        List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(extractor);
        }
        Compress compressor = new Compress();
        for(ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(compressor);
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
