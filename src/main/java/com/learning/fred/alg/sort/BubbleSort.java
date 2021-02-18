package com.learning.fred.alg.sort;

import java.util.Arrays;

/**
 * @author fred
 * @date 2021/2/4 09:45
 * @description 从 小 到 大 冒泡
 */
public class BubbleSort {

    /**
     * 从 小 到 大 冒泡,
     * @param a
     * @param n
     */
    public static void bubbleSort1(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < n - i -1; j++) {

                if (a[j + 1] < a[j]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }

            }
        }
    }

    /**
     * 没有交换，则 说明已经排序成功
     * @param a
     * @param n
     */
    public static void bubbleSort2(int[] a, int n) {

        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            //标记是否存在 排序
            boolean flag = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (a[j+ 1] < a[j]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {5,3,6,1,2,6,4};

        bubbleSort1(a, a.length);

//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i]);
//        }
        Arrays.stream(a).forEach(s -> System.out.println(s));
        bubbleSort2(a, a.length);
        Arrays.stream(a).forEach(s -> System.out.println(s));
    }
}
