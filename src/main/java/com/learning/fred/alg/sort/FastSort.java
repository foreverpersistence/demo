package com.learning.fred.alg.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author fred
 * @date 2021/2/4 19:25
 * @description 快排
 * 快排的思想是这样的:如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot(分区点)。
 *
 *  时间复杂度 O(nlogn)
 *  原地算法
 *  不稳定算法
 */
public class FastSort {

    private static final Logger LOGGER = LoggerFactory.getLogger(FastSort.class);

    public static void quickSort(int[] a, int n) {
        quickSortInternal(a,0, n-1);
    }

    private static void quickSortInternal(int[] a, int p, int r) {

        if (p >= r) {
            return;
        }

        int q = partition(a, p, r);

        quickSortInternal(a, p, q -1);
        quickSortInternal(a,q + 1, r);
    }

    /**
     * 根据 i， j 下标移动来 区分 privor 大于和小于的 两部分。
     *  依次遍历 数据元素， 比较 小于，则 移动 i++
     * @param a
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] a, int p, int r) {

        int privor = a[r];//最后一个作为 基准点

        int i = p;
        for (int j = p;  j < r; j++) {
            if (a[j] < privor) {
                if (i == j) {//小于
                    ++i;//移动 小于的 下标
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }

        }

        //与 i+1 交换
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        LOGGER.info("i=[{}]", i);
        return i;

    }




    public static void main(String[] args) {

//        int[] a = {1,2,3,4,5,6};
//        quickSort(a, 6);
//        print(a);

        int[] b = {6,5,4,3,2,1};
        quickSort(b, 6);
        print(b);

        int[] c = {4,6,3,5,1,2};
        quickSort(c, 6);
        print(c);

    }


    /**
     * O(n)  时间复杂度内求无序数组中的第 K  大元素。比如， 4 ， 2 ， 5 ， 12 ， 3  这样一组数据，第 3  大元素就是 4 。
     *
     * @param arr
     */
    public static int sort(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return 0;
        }
        int p = partition(arr, l, r);
        if ((p + 1) == k) {
            return arr[p];
        } else if ((p + 1) < k) {
            return sort(arr, p + 1, r, k);
        } else {
            return sort(arr, l, p - 1, k);
        }
    }


    static void print(int[] a) {
        Arrays.stream(a).forEach(System.out::println);
    }
}
