/*
 * @Author: Weidows
 * @Date: 2020-07-25 22:03:37
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-21 18:18:30
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\exception\ArrayIndex.java
 */
package twenty.july.exception;

public class ArrayIndex {
  private static void f() {
    int[] a = new int[10];
    a[10] = 10; //!异常产生处
    System.out.println("hello");
  }

  private static void g() {
    f();
  }

  private static void h() {
    int i = 10;
    if (i < 100) {
      g();
    }
  }

  public static void k() {
    try { //检测h()是否存在异常
      h();
    } catch (NullPointerException e) {
      System.out.println("catch错误的异常");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("catch正确的异常");
      /**
       *  抛出异常,也就是令程序仍存在这个异常状态
       * 如果这个异常执行到最外层main仍未得到解决,则程序报错终止
       */
      throw e;
    }
  }
}

class A {
  public static void main(String[] args) {
    /**
    * try-catch异常捕捉
    * *try尝试,如果捕捉到catch对应的异常后执行catch后面的指令
    * *若异常无对应的catch,则该异常在此处不被catch,被throw到更外层(main方法)
    * !try所有异常都得到对应catch才能判定无异常,除非在catch中throw出异常
    */
    try {
      //? 因为是静态方法,不需要实例就可以调用
      ArrayIndex.k();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("caught");
      System.out.println(e.getMessage());
      System.out.println(e);
      e.printStackTrace();
    }
    System.out.println("Over");

  }
}
