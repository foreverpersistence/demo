package com.learning.fred.design.principle.pattern.action.strategy.demo;

import java.io.File;

/**
 * @author fred
 * @date 2020/12/25 14:22
 * @description todo
 */
public class Sorter {

    public static final long GB = 1000 * 1000 * 1000;

    public void sortFile2(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();

        ISortAlg sortAlg;
        if (fileSize < 6 * GB) {
            sortAlg = new QuickSort();
        } else if (fileSize < 10 *GB) {
            sortAlg = new ExternalSort();
        } else if (fileSize < 100 * GB) {
            sortAlg = new ConcurrentExternalSort();
        } else {
            sortAlg = new MapReduceSort();
        }

        sortAlg.sort(filePath);

    }

    public void sortFile(String filePath) {
        //
        File file = new File(filePath);
        long fileSize = file.length();

        if (fileSize < 6 * GB) {
            quickSort(filePath);
        } else if (fileSize < 10 *GB) {
            externalSort(filePath);
        } else if (fileSize < 100 * GB) {
            concurrentExtranalSort(filePath);
        } else {
            mapreduce(filePath);
        }
    }

    private void mapreduce(String filePath) {
        //map reduce
    }

    private void concurrentExtranalSort(String filePath) {
        //多线程 外部排序
    }

    private void externalSort(String filePath) {
        //外部排序
    }

    private void quickSort(String filePath) {
        // 快排
    }
}
