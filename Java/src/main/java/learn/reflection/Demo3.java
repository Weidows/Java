/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-26 16:58:37
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-27 13:33:31
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\reflection\Demo3.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.reflection;

public class Demo3 {
  public static void main(String[] args) {
    // A a = new A();
    System.out.println(A.m);//300
    /*
    1.加载到内存，产生一个类对应Class对象
    2.链接，链接结束后m=◎
    3.初始化
    <clinit>(){
        m=100;
        System.out.println( "A类静态代码块初始化");
        m = 300;
     }
     */
  }
}

class A {
  // * 1.1
  static int m = 100;

  // * 1.2
  static {
    System.out.println("A类静态代码块初始化");
    m = 300;
  }

  // * 2
  public A() {
    System.out.println("A类的构造初始化");
  }
}
