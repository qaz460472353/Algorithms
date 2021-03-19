package com.Algorithms.DesignMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 建造者模式
 * @Author ZY
 * @Date 2021/1/9 16:38
 **/
public class BuilderMode {
    private List<Sender> list = new ArrayList<>();

    public static void main(String[] args) {
        BuilderMode builder = new BuilderMode();
        builder.produceMailSender(10);
    }

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }
    public interface Sender {
        public void Send();
    }

    public class MailSender implements Sender {

        @Override
        public void Send() {
            System.out.println("this is mail sender!");
        }
    }
    public class SmsSender implements Sender {

        @Override
        public void Send() {
            System.out.println("this is sms sender!");
        }
    }
}
