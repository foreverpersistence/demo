package com.learning.fred.alg.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author fred
 * @date 2021/2/4 13:27
 * @description 归并排序
 *  根据 数组中 去一个点 吧  a[0,r], 分成 a[q], a[q]，分别排序，在进行 合并。
 *   分治思想
 *   时间复杂度：O(nlogn)，  最差 时间复杂度 O(n^2)
 *   稳定算法
 *   不是 原地算法。
 *   空间复杂度：O(n)
 *
 *
 */
public class MergeSort {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergeSort.class);

    public static void mergeSort(int[] a, int n) {

        mergeSortInternal(a, 0, n-1);
    }

    /**
     * 排序 并 合并
     * @param a
     * @param p
     * @param r
     */
    private static void mergeSortInternal(int[] a, int p, int r) {
        LOGGER.info("p:[{}] - r:[{}]", p, r);
        if (p>=r) {
            return;
        }
        int q = (p + r) / 2;
        LOGGER.info("q:[{}]", q);
        mergeSortInternal(a, p, q);
        mergeSortInternal(a,q + 1, r);

        //合并 a[p,q] a[q+1, r]
        merge(a,p, q, r);
    }

    /**
     * 合并
     * @param a
     * @param p
     * @param q
     * @param r
     */
    private static void merge(int[] a, int p, int q, int r) {

        int[] tmp = new int[r - p + 1];
        int i = p;
        int j = q+1;
        int k = 0;
        while (i<=q && j <=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个 部分还有剩余(一定会有)
        if(i > q) {
            while (j<=r) {
                tmp[k++] = a[j++];
            }
        } else
        if (j > r) {
            while(i <= q) {
                tmp[k++] = a[i++];
            }
        }

        //设置回 a
        for (int l = 0; l <= r - p; l++) {
            LOGGER.info("tmp[{}} = {}", l, tmp[l]);
            a[p+l] = tmp[l];
        }
    }

    public static void main(String[] args) {

//        int[] a = {1,3,6,5};
//        mergeSort(a, 4);
//        print(a);

        int[] b = {4,3,2,1};
        mergeSort(b, 4);
        print(b);

    }


    static void print(int[] a) {
        Arrays.stream(a).forEach(System.out::println);
    }
}
