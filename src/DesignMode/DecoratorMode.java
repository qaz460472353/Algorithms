package DesignMode;

/**
 * @Description 装饰器模式
 * @Author ZY
 * @Date 2021/1/9 17:26
 **/
public class DecoratorMode {
    public interface Sourceable {
        public void method();
    }

    public static class Source implements Sourceable {

        @Override
        public void method() {
            System.out.println("the original method!");
        }
    }
    public static class Decorator implements Sourceable {
        private Sourceable source;
        public Decorator(Sourceable source) {
            super();
            this.source = source;
        }
        @Override
        public void method() {
            System.out.println("before decorator!");
            source.method();
            System.out.println("after decorator!");
        }
    }

    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
