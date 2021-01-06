package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description TODO
 * @Author ZY
 * @Date 2021/1/6 16:02
 **/
public class MyCallable implements Callable {
    @Override
    public Integer call() throws Exception {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable callable = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(callable);
        Thread thread = new Thread();
        thread.start();
        System.out.println(ft.get());
    }
}
