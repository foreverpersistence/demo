package com.learning.fred.alg.search;

/**
 * @author fred
 * @date 2021/2/18 09:39
 * @description 二分
 */
public class BSearch {

    /**
     * 不重复的 有序 数组
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bsearch(int[] a, int n, int value) {

        int low = 0;
        int hight = n -1;

        while (low <= hight) {
//            int mid = (low + hight) /2;// 溢出风险
            int mid = low + ((hight - low) >> 1);

            if (a[mid] == value) {
                return mid;
            } else  if (a[mid] < value) {
                low = mid + 1;
            } else {
                hight = mid -1;
            }

        }

        return -1;
    }

    /**
     * 递归 查找
     * @param a
     * @param low
     * @param hight
     * @param value
     * @return
     */
    private int bsearchInternally(int[] a, int low, int hight, int value) {
        if (low > hight) {
            return -1;
        }
        int mid = low + ((hight - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid+1, hight, value);
        } else {
            return bsearchInternally(a, mid, mid -1, value);
        }

    }

    /**
     * 查找第一个值等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchFirstValue(int[] a, int n, int value) {
        int low = 0;
        int hight = n -1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (a[mid] > value) {
                hight = mid - 1;
            } else if (a[mid] < value){
                low = mid + 1;
            } else {//相等， 判断 前一个元素是否 相等
//                if (a[mid] == value) { //边界 不全
////                    hight = mid -1;
////                } else {
////                    return mid;
////                }

                if (mid == 0 || a[mid] != value) {
                    return mid;
                } else {
                    hight = mid -1;
                }
            }
        }

        return -1;
    }

    /**
     * 变体二:查找最后一个值等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchLastValue(int[] a, int n, int value) {
        int low = 0;
        int hight = n -1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (a[mid] > value) {
                hight = mid -1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {// 需要判断 后一个是否相等
                if (mid == n -1 || a[mid +1] !=value) {
                    return mid;
                }else {
                    low = mid + 1;
                }
            }

        }
        return -1;
    }

    /**
     * 变体三:查找第一个大于等于给定值的元素**
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchFirstGEValue(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {//大于 等于 做判断
                if ((mid == 0) || (a[mid - 1] < value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变体四:查找最后一个小于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bsearchLastLEValue(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {//小于 等于 做判断
                if ((mid == n -1) || (a[mid + 1] > value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] a = {2,4,6,9,12,13};
        int index = bsearch(a, 6, 9);
        System.out.println(index);
    }
}
