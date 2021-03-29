package com.Algorithms.中科三清;

public class NumPrinterDemo {

    private final Object monitor = new Object();

    private volatile int num;

    public NumPrinterDemo(int num) {
        this.num = num;
    }

    public void print() {
        synchronized (monitor) {
            while (true) {
                try {
                    System.out.println(String.format("线程[%s]:%d", Thread.currentThread().getName(), ++num));
                    monitor.notifyAll();
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        NumPrinterDemo numPrinterDemo = new NumPrinterDemo(0);
        Thread thread1 = new Thread(() -> numPrinterDemo.print(), "thread-1");
        Thread thread2 = new Thread(() -> numPrinterDemo.print(), "thread-2");
        thread1.start();
        thread2.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}