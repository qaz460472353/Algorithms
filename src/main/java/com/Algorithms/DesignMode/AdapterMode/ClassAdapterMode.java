package com.Algorithms.DesignMode.AdapterMode;

/**
 * @Description 类的适配器模式
 * @Author ZY
 * @Date 2021/1/9 16:58
 **/
public class ClassAdapterMode {
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
    public static class Adapter extends Source implements Targetable {

        @Override
        public void method2() {
            System.out.println("this is Targetable method!");
        }
    }

    public static void main(String[] args) {
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }

}
