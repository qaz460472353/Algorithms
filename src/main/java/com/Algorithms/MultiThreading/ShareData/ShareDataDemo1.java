package com.Algorithms.MultiThreading.ShareData;

/**
 * @Description
 * @Author ZY
 * @Date 2021/1/6 16:48
 **/
public class ShareDataDemo1 {
    /**
     * 共享数据类
     */
    static class ShareData {
        private int num = 10;
        public synchronized void inc() {
            num++;
            System.out.println(Thread.currentThread().getName()+": invoke inc method num =" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 多线程类
     */
    static class RunableCusToInc implements Runnable {
        private ShareData ShareData;

        public RunableCusToInc(ShareData data) {
            this.ShareData = data;
        }
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                ShareData.inc();
            }
        }
    }

    /**
     * 测试方法
     */
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i < 4; i++) {
            new Thread(new RunableCusToInc(shareData),"Thread"+i).start();
        }
    }
}
