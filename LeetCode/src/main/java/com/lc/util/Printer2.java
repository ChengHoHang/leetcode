package com.lc.util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chanhaoheng
 * @date 2023/7/11
 */
public class Printer2 {

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static final Condition aCondition = LOCK.newCondition();

    private static final Condition bCondition = LOCK.newCondition();



    public static void main(String[] args) throws InterruptedException {
        Thread printA = new Thread(() -> print(bCondition, aCondition, "a"));

        Thread printB = new Thread(() -> print(aCondition, bCondition, "b"));

        printA.start();
        printB.start();

        Thread.sleep(1000);

        System.out.println(printA.getState());
        System.out.println(printB.getState());

        printA.join();
        printB.join();
    }

    private static void print(Condition notify, Condition await, String code) {
        LOCK.lock();
        try {
            notify.signal();
            System.out.println(code);
            try {
                await.await();
            } catch (InterruptedException ignored) {}
            System.out.println(code + "唤醒勒");
        } finally {
            System.out.println("没执行unlock " + code + ", getLock:" + LOCK.isHeldByCurrentThread());
            LOCK.unlock();
        }
    }
}
