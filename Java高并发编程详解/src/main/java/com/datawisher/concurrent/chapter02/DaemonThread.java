package com.datawisher.concurrent.chapter02;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {

        // main 线程开始
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setDaemon(true);

        thread.start();
        Thread.sleep(2000L);
        System.out.println("Main thread finished lifecycle.");
    }
}
