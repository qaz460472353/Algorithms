package DesignMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 动态代理类
 * @Author ZY
 * @Date 2021/1/9 15:04
 **/
public class DynamicProxy {
    public static void main(String[] args) {

    }

    /**
     * 写一个ArrayList的动态代理类
     */
    public void ArrayListDP() {

        final List<String> list = new ArrayList<>();

        List<String> proxyInstance = (List<String>) Proxy.newProxyInstance(
                list.getClass().getClassLoader(),
                list.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(list,args);
                    }
                });
        proxyInstance.add("hello,world");
        System.out.println(list);
    }
}
