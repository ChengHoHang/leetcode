package com.lc.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chanhaoheng
 * @date 2023/6/29
 */
public class TenThreads {

    private static volatile AtomicInteger reserve = new AtomicInteger(1000);

    private static class WaitThread extends Thread {

        public WaitThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            reserve.decrementAndGet();
            System.out.println(Thread.currentThread());
            while (reserve.get() > 0) {
                if (reserve.get() <= 0) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            WaitThread waitThread = new WaitThread(String.valueOf(i));
            waitThread.start();
        }

        Thread.sleep(3000);
    }
}
