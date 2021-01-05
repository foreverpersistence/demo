package com.learning.fred.design.principle.action.template;

/**
 * @author fred
 * @date 2020/12/25 11:50
 * @description todo
 */
public class ShutdownHookDemo {

    private static class ShutdownHook extends Thread {
        @Override
        public void run() {
            System.out.println("called during shutting down");
        }
    }

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }
}
