package com.datawisher.concurrent.chapter02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 堆内存不变，栈内存越大，线程数越少
 * 可粗略认为Java进程的内存大小为：堆内存 + （线程数量 ×　栈内存）
 */
public class ThreadCounter extends Thread {

    final static AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) {

        try {
            while (true) {
                new ThreadCounter().start();
            }
        } catch (Throwable e) {
            System.out.println("failed At => " + counter.get());
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("The " + counter.getAndIncrement() + " thread be created.");
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
