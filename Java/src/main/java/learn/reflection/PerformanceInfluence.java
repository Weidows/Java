/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-27 18:35:57
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-27 18:43:46
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\reflection\PerformanceInfluence.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.reflection;

import java.lang.reflect.Method;

public class PerformanceInfluence {

  public static void main(String[] args) throws Exception {
    test1();
    test2();
    test3();
    /**
      普通方式执行4ms
      反射方式,开启检测执行2794ms
      反射方式,关闭检测执行1771ms
     */
  }

  public static void test1() {
    User user = new User();
    long start = System.currentTimeMillis();
    for (int i = 0; i < 1000000000; i++) {
      user.getName();
    }
    long end = System.currentTimeMillis();
    System.out.println("普通方式执行" + (end - start) + "ms");
  }

  public static void test2() throws Exception {
    User user = new User();
    Class c1 = user.getClass();
    Method getName = c1.getDeclaredMethod("getName", null);

    long start = System.currentTimeMillis();
    for (int i = 0; i < 1000000000; i++) {
      getName.invoke(user, null);
    }
    long end = System.currentTimeMillis();
    System.out.println("反射方式,开启检测执行" + (end - start) + "ms");
  }

  public static void test3() throws Exception {
    User user = new User();
    Class c1 = user.getClass();
    Method getName = c1.getDeclaredMethod("getName", null);

    long start = System.currentTimeMillis();
    getName.setAccessible(true);
    for (int i = 0; i < 1000000000; i++) {
      getName.invoke(user, null);
    }
    long end = System.currentTimeMillis();
    System.out.println("反射方式,关闭检测执行" + (end - start) + "ms");
  }
}
