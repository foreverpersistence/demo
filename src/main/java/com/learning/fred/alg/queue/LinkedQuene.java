package com.learning.fred.alg.queue;

/**
 * @author fred
 * @date 2021/2/3 16:21
 * @description 链式队列
 */
public class LinkedQuene {

    private Node head = null;
    private Node tail = null;

    public LinkedQuene() {
    }

    public boolean enquene(String item) {
        Node node = new Node(item);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        return true;
    }

    /**
     * 出队
     */
    public String dequene() {
        if (head == null) {
            return null;
        }
        String value = head.value;

        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;

    }


    public static void main(String[] args) {
        LinkedQuene linkedQuene = new LinkedQuene();
        linkedQuene.enquene("1");
        linkedQuene.enquene("2");
        linkedQuene.enquene("3");
        linkedQuene.enquene("4");
        linkedQuene.enquene("5");

        System.out.println(linkedQuene.dequene());
        System.out.println(linkedQuene.dequene());
        System.out.println(linkedQuene.dequene());
        System.out.println(linkedQuene.dequene());
        System.out.println(linkedQuene.dequene());
    }
}
class Node {
    public String value;
    public Node next; //只能 往后新增，删前面的

    public Node() {
    }

    public Node(String value) {
        this.value = value;
    }


}