/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-27 16:47:34
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-27 17:07:39
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\reflection\Demo4.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.reflection;

public class Demo4 {

  static {
    System.out.println("main类被加载");
  }

  public static void main(String[] args) throws ClassNotFoundException {
    //1.主动引用
    // Son son = new Son();
    /*
    * main类被加载
    * 父类被加载
    * 子类被加载
    * */

    //反射也会产生主动引用
    // Class.forName("twenty_one.reflection.Son");
    /*
     * main类被加载
     * 父类被加载
     * 子类被加载
     * */

    //不会产生类的引用的方法
    // System.out.println(Son.b);
    /*
    * main类被加载
    * 父类被加载
    * 2
    * */

    //只会main类被加载
    // System.out.println(Son.M);
    /*
     * main类被加载
     * 1
     * */

    //全加载
    System.out.println(Son.m);
    /*
     * main类被加载
     * 父类被加载
     * 子类被加载
     * 100
     */
  }
}

class Father {
  static int b = 2;
  static {
    System.out.println("父类被加载");
  }
}

class Son extends Father {
  static {
    System.out.println("子类被加载");
  }
  static int m = 100;
  static final int M = 1;
}
