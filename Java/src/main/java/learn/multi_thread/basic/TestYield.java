/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-19 23:23:04
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-20 00:02:02
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\multi_thread\TestYield.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.basic;

public class TestYield {
  public static void main(String[] args) {
    // MyYield myYield = new MyYield();

    // * 匿名内部类的方式
    // Runnable myYield = new Runnable() {
    //   @Override
    //   public void run() {
    //     System.out.println(Thread.currentThread().getName() + "线程开始执行");
    //     Thread.yield(); //礼让
    //     System.out.println(Thread.currentThread().getName() + "线程停止执行");
    //   }
    // };

    // * Lambda表达式方式
    Runnable myYield = () -> {
      System.out.println(Thread.currentThread().getName() + "线程开始执行");
      Thread.yield(); //礼让
      System.out.println(Thread.currentThread().getName() + "线程停止执行");
    };

    new Thread(myYield, "a").start();
    new Thread(myYield, "b").start();
  }
}

// * 新建类的方式实现接口
// class MyYield implements Runnable {
//   @Override
//   public void run() {
//     System.out.println(Thread.currentThread().getName() + "线程开始执行");
//     Thread.yield(); //礼让
//     System.out.println(Thread.currentThread().getName() + "线程停止执行");
//   }
// }
