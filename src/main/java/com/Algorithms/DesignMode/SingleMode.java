package com.Algorithms.DesignMode;

/**
 * @Description 单例设计模式
 * @Author ZY
 * @Date 2021/1/9 15:28
 **/
public class SingleMode {
    /**
     * 饿汉式
     */
    public static class hungrySingleton {
        // 直接创建对象
        public static hungrySingleton instance = new hungrySingleton();
        // 私有化构造函数
        private hungrySingleton() {}

        // 提供对外方法
        public static  hungrySingleton getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉式
     */
    public static class LazySingleton {
        // 声明变量
        private static volatile LazySingleton singleton= null;
        // 私有构造函数
        private LazySingleton() {}
        // 提供对外方法
        public static LazySingleton getInstance() {
            if (singleton == null) {
                synchronized (LazySingleton.class) {
                    if (singleton == null) {
                        singleton = new LazySingleton();
                    }
                }
            }
            return singleton;
        }
    }
}
