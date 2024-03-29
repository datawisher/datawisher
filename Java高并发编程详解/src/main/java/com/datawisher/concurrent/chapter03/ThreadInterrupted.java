package com.datawisher.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.interrupted());
                }
            }
        };

        thread.setDaemon(true);
        thread.start();

        // shortly block make sure the thread is started
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
        thread.interrupt();

    }
}
