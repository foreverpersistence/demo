package com.learning.fred.design.principle.pattern.action.strategy.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fred
 * @date 2020/12/25 15:11
 * @description todo
 */
public class Sort2 {

    private static final long GB = 1000 * 1000 * 1000;
    private static final List<AlgRange> algs = new ArrayList<>();

    static {
        algs.add(new AlgRange(0, 6 * GB, SortAlgFactory.getSortAlg("quick")));
        algs.add(new AlgRange(6, 10 * GB, SortAlgFactory.getSortAlg("quick")));
        algs.add(new AlgRange(10, 100 * GB, SortAlgFactory.getSortAlg("quick")));
        //...
    }

    /**
     * 通过 循环 避免了 if-else
     * @param filePath
     */
    public void sortFile(String filePath) {
        File file = new File(filePath);
        long length = file.length();
        ISortAlg sortAlg = null;
        for (AlgRange alg : algs) {
            if (alg.inRange(length)) {
                sortAlg = alg.getAlg();
                break;
            }
        }
        sortAlg.sort(filePath);
    }
}
