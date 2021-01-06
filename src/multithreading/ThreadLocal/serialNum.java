package multithreading.ThreadLocal;

/**
 * @Description 私有静态ThreadLocal实例（serialNum）为调用该类的静态SerialNum.get()方法的每个线程维护了一个序列号，
 * 该方法返回当前线程的序列号。
 * @Author ZY
 * @Date 2021/1/6 16:39
 **/
public class serialNum {
    private static int nextSerialNum = 0;

    private static ThreadLocal serialNum = new ThreadLocal() {
      @Override
      protected synchronized Object initialValue() {
          return new Integer(nextSerialNum++);
      }
    };

    public static int get() {
        return ((Integer) (serialNum.get())).intValue();
    }
}
