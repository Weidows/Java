/*
 * @Author: Weidows
 * @Date: 2020-11-02 23:16:17
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-02 23:46:39
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\proxy\ProxyDemo.java
 * @Description:动态代理类
 */
package twenty.november.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyDemo implements InvocationHandler {
  Object obj; //被代理的对象

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("Before invoke run");
    Object result = method.invoke(obj, args); //执行的是指定代理对象的指定方法
    System.out.println("After invoke run");
    return result;
  }

  public ProxyDemo(Object obj) {
    this.obj = obj;
  }

}
