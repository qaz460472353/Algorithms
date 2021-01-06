package multithreading;

/**
 * @Description 子线程运行执行10次后，主线程再运行5次，这样交替执行三遍
 * @Author ZY
 * @Date 2021/1/6 16:26
 **/
public class RunnableDemo1 {
    public static void main(String[] args) {
        final Bussiness bussiness = new Bussiness();
        // 子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3 ; i++) {
                    bussiness.subMethod();
                }
            }
        }).start();
        // 主线程
        for (int i = 0; i < 3; i++) {
            bussiness.mainMethod();
        }
    }
    static class Bussiness {
        private Boolean subFlag = true;
        public synchronized void mainMethod() {
            while (subFlag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": main thread running loop count --" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            subFlag = true;
            notify();
        }
        public synchronized void subMethod() {
            while (!subFlag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": sub thread running loop count --" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            subFlag = false;
            notify();
        }
    }
}
