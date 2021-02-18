package com.learning.fred.alg.queue;

/**
 * @author fred
 * @date 2021/2/3 15:57
 * @description FIFO
 */
public class ArrayQueue {

    private String[] items;
    private int n=0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队， 数组 空间 利用率不足
     * @param item
     * @return
     */
    public boolean enquene(String item) {
        if (tail == n) {
            //数组迁移
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i-head] = items[head];
            }
            //迁移完后, 更新  head， tail
            tail -= head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }

    /**
     * head out 出队
     * @return
     */
    public String dequene() {

        if (head == tail) {
            return null;
        }
        return items[head++];
    }
}
