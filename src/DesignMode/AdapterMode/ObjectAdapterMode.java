package DesignMode.AdapterMode;

/**
 * @Description 对象的适配器模式
 * @Author ZY
 * @Date 2021/1/9 17:05
 **/
public class ObjectAdapterMode {
    public static class Source {
        public void method1() {
            System.out.println("this is original method!");
        }
    }
    public interface Targetable {
        // 与原类中方法相同
        public void method1();
        // 新类的方法
        public void method2();
    }

    public static class Wrapper implements Targetable {
        private Source source;
        public Wrapper(Source source) {
            super();
            this.source = source;
        }
        @Override
        public void method1() {
            source.method1();
        }

        @Override
        public void method2() {
            System.out.println("this is Targetable method!");
        }
    }

    public static void main(String[] args) {
        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method2();
    }

}
