/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-20 23:58:16
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-21 00:57:37
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\multi_thread\TestJoin.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.basic;

public class TestJoin {
  public static void main(String[] args) throws InterruptedException {
    Runnable testJoin = () -> {
      for (int i = 0; i < 100; i++) {
        System.out.println("vipThread" + i);
      }
    };
    Thread vipThread = new Thread(testJoin);
    vipThread.start();

    //主线程
    for (int i = 0; i < 100; i++) {
      if (i == 50) {
        vipThread.join(); //插队
      }
      System.out.println("main" + i);
    }
  }
}
