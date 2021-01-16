package MultiThreading.Executor;

import java.util.concurrent.*;

/**
 * @Description 连接池
 * @Author ZY
 * @Date 2021/1/8 9:33
 **/
public class ThreadPool {
    /**
     * 运行结果：
     *  pool-1-thread-1正在执行...
     *  pool-1-thread-2正在执行...
     *  pool-1-thread-2正在执行...
     */
    public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
        // ExecutorService fPool = Executors.newFixedThreadPool(2);
        // 创建一个单任务线程池
        // ExecutorService fPool = Executors.newSingleThreadExecutor();
        // 创建一个可变线程数的线程池
        // ExecutorService fPool = Executors.newCachedThreadPool();
        // 创建一个延迟连接池，它可安排在给定延迟后运行命令或定期执行
        ScheduledExecutorService fPool = Executors.newScheduledThreadPool(2);

        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runable接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        // 将线程池放入池中执行
        fPool.execute(t1);
        fPool.execute(t2);
        fPool.execute(t3);
        // 使用定时执行风格的方法,t4和t5在10秒后执行
        fPool.schedule(t4,10, TimeUnit.MICROSECONDS);
        fPool.schedule(t5,10, TimeUnit.MICROSECONDS);
        // 关闭线程池
        fPool.shutdown();
    }
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在执行...");
        }
    }
}
