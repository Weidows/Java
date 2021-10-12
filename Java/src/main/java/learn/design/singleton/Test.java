/*
 * @Author: Weidows
 * @Date: 2020-09-29 00:25:11
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-29 17:48:54
 * @FilePath: \Weidows\Java\src\main\java\design\singleton\Test.java
 */
package learn.design.singleton;

public class Test {
  public static void main(String[] args) {
    ///这几个栈指向的是堆里的同一个类成员对象
    Single_1 s1 = Single_1.getInstance();
    Single_1 s2 = Single_1.getInstance();
    Single_1 s3 = Single_1.getInstance();

    ///懒汉式写法:
    Single_2 s4 = Single_2.getInstance();
    Single_2 s5 = Single_2.getInstance();
    Single_2 s6 = Single_2.getInstance();
  }
}
