package com.learning.fred.design.principle.action.strategy.demo;

/**
 * @author fred
 * @date 2020/12/25 14:36
 * @description 用于去除 if else ，查表
 */
public class AlgRange {

    private long start;
    private long end;
    private ISortAlg alg;

    public AlgRange(long start, long end, ISortAlg alg) {
        this.start = start;
        this.end = end;
        this.alg = alg;
    }

    public ISortAlg getAlg() {
        return alg;
    }

    public void setAlg(ISortAlg alg) {
        this.alg = alg;
    }

    public boolean inRange(long size) {
        return size >= start && size < end;
    }
}
