/*
 * @Author: Weidows
 * @Date: 2020-09-29 17:09:41
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-29 23:54:58
 * @FilePath: \Weidows\Java\src\main\java\design\singleton\Single_2.java
 *
 * 单例---懒汉式写法
 */
package learn.design.singleton;

public class Single_2 {
  private static Single_2 instance = null;

  private Single_2() {

  }

  public static Single_2 getInstance() {
    if (instance == null)
      instance = new Single_2();
    return instance;
  }

  public static void main(String[] args) {

  }
}
