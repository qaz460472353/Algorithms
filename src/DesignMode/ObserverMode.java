package DesignMode;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Description 观察者模式
 * @Author ZY
 * @Date 2021/1/9 21:09
 **/
public class ObserverMode {
    public interface Observer {
        public void update();
    }
    public static class Observer1 implements Observer {

        @Override
        public void update() {
            System.out.println("Observer1 has received!");
        }
    }
    public static class Observer2 implements Observer {

        @Override
        public void update() {
            System.out.println("Observer2 has received!");
        }
    }
    public interface Subject {
        // 增加观察者
        public void add(Observer observer);
        // 删除观察者
        public void del(Observer observer);
        // 通知所有观察者
        public void notifyObserver();
        // 自身的操作
        public void operation();
    }

    public static abstract class AbstractSubject implements Subject {
        private Vector<Observer> vector = new Vector<>();


        @Override
        public void add(Observer observer) {
            vector.add(observer);
        }

        @Override
        public void del(Observer observer) {
            vector.remove(observer);
        }

        @Override
        public void notifyObserver() {
            Enumeration<Observer> enumo = vector.elements();
            while (enumo.hasMoreElements()) {
                enumo.nextElement().update();
            }
        }
    }
    public static class MySubject extends AbstractSubject {

        @Override
        public void operation() {
            System.out.println("update self!");
        }

    }

    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());
        sub.operation();
    }
}
