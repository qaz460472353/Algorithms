package MultiThreading;

/**
 * @Description TODO
 * @Author ZY
 * @Date 2021/1/6 16:02
 **/
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("123");
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
