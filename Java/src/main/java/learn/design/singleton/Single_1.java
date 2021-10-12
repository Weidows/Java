/*
 * @Author: Weidows
 * @Date: 2020-09-29 00:17:06
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-29 17:08:26
 * @FilePath: \Weidows\Java\src\main\java\design\singleton\Single_1.java
 *
 * 单例---饿汉式写法
 */
package learn.design.singleton;

public class Single_1 {
  //私有的类成员变量
  private static Single_1 instance = new Single_1();

  //私有化构造方法,只能本类及内部类可以new这个类的对象
  private Single_1() {

  }

  public static Single_1 getInstance() {
    return instance;
  }

  public static void main(String[] args) {
  }
}
