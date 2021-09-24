/*
 * @Author: Weidows
 * @Date: 2020-11-02 23:08:14
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-03 00:10:55
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\proxy\Main.java
 * @Description:动态代理
 */
package twenty.november.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
  public static void main(String[] args) {
    TestInterface test = new Test();
    test.test_1();
    test.test_2();
    System.out.println("-------------------------------------------------");

    /**
     * ! Demand
     * <p>Add something to run before test()
     * <p>Print's outputing method name be the same as who has called
     */

    InvocationHandler handler = new ProxyDemo(test); //? 代理对象
    /**
     * param 1 代理对象的类加载器
     * param 2 被代理对象的接口
     * param 3 代理对象
     * 对象想要被代理,需要这个对象的类有相应的接口
     */
    TestInterface proxy = (TestInterface) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
        test.getClass().getInterfaces(), handler); //? 被代理对象
    proxy.test_1();
    System.out.println("-------------------------------------------------");
    proxy.test_2();
  }
}
