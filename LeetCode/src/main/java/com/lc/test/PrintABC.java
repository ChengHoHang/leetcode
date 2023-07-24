package com.lc.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author chanhaoheng
 * @date 2023/6/29
 */
public class PrintABC {

    private static CountDownLatch aLatch = new CountDownLatch(1);

    private static Thread a = new Thread(() -> {
        System.out.println("a");
        aLatch.countDown();
    });

    private static CountDownLatch bLatch = new CountDownLatch(1);

    private static Thread b = new Thread(() -> {
        System.out.println("b");
        bLatch.countDown();
    });

    private static Thread c = new Thread(() -> {
        System.out.println("c");
    });

    public static void main(String[] args) throws InterruptedException {
        a.start();
        aLatch.await();
        b.start();
        bLatch.await();
        c.start();
    }
}
