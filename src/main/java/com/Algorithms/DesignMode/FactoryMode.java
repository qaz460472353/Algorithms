package com.Algorithms.DesignMode;

/**
 * @Description 工厂模式
 * @Author ZY
 * @Date 2021/1/9 16:08
 **/
public class FactoryMode {

    public interface Sender {
        public void Send();
    }

    public static class MailSender implements Sender {

        @Override
        public void Send() {
            System.out.println("this is mail sender!");
        }
    }
    public static class SmsSender implements Sender {

        @Override
        public void Send() {
            System.out.println("this is sms sender!");
        }
    }
    /**
     * 普通工厂模式
     */
    public static class SendFactory {
        public Sender produce(String type) {
            if ("mail".equals(type)) {
                return new MailSender();
            } else if ("sms".equals(type)) {
                return new SmsSender();
            } else {
                System.out.println("请输入正确的类型！");
                return null;
            }
        }
    }

    /**
     * 多个方法工厂模式
     */
    public static class MultSendFactory {
        public Sender produceMail() {
            return new MailSender();
        }

        public Sender produceSms() {
            return new SmsSender();
        }
    }
    public static class FactoryTest {
        public static void main(String[] args) {
            MultSendFactory factory = new MultSendFactory();
            Sender sender = factory.produceMail();
            sender.Send();
        }
    }

}
