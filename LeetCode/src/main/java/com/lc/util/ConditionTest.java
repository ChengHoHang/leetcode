package com.lc.util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chanhaoheng
 * @date 2023/7/19
 */
public class ConditionTest {

    /**
     * await
     * signal done
     * threadB unlock
     * wakeup
     * threadA unlock
     */
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("await");
                condition.await();
                System.out.println("wakeup");
            } catch (InterruptedException e) {
                System.out.println("1111");
            } finally {
                System.out.println("threadA unlock");
                lock.unlock();
            }
        });

        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("threadA state:" + threadA.getState());
                condition.signal();
                System.out.println("signal done");
                System.out.println("threadA state:" + threadA.getState()); // waiting
            } finally {
                System.out.println("threadB unlock");
                lock.unlock();
            }
        });

        threadA.start();
        threadB.start();


        threadA.join();
        threadB.join();
    }
}
