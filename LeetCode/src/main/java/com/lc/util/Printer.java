package com.lc.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chanhaoheng
 * @date 2023/7/11
 */
public class Printer {

    private static final Object lock = new Object();

    private static final CountDownLatch LATCH = new CountDownLatch(1);

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void print(String code) {
        while (counter.getAndIncrement() < 100) {
            synchronized (lock) {
                lock.notifyAll();
                System.out.println(code + counter.get());
                if (counter.get() < 100) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ignored) {}
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {}
            LATCH.countDown();
            print("a");
        });
        a.start();


        Thread b = new Thread(() -> {
            try {
                LATCH.await();
            } catch (InterruptedException ignored) {}
            print("b");
        });
        b.start();

        a.join();
        b.join();
    }
}
