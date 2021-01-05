package com.learning.fred.design.principle.action.strategy.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fred
 * @date 2020/12/25 14:33
 * @description todo
 */
public class SortAlgFactory {

    private static final Map<String, ISortAlg> algs = new HashMap<>();
    static {
        algs.put("quick", new QuickSort());
        algs.put("external", new ExternalSort());
        algs.put("concurrent", new ConcurrentExternalSort());
        algs.put("mapreduce", new MapReduceSort());
    }

    public static ISortAlg getSortAlg(String type) {
        //check

        return algs.get(type);
    }
}
