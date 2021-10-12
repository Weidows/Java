/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-19 17:45:00
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-19 17:55:46
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\multi_thread\TestStop.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.basic;

public class TestStop implements Runnable {
  //1.设置一个标志位
  private boolean flag = true;

  @Override
  public void run() {
    int i = 0; // 运行次数
    while (flag) {
      System.out.println("Thread.run()运行次数: " + i++);
    }
  }

  //2.设置一个公开的方法停止线程，转换标志位
  public void stop() {
    this.flag = false;
  }

  public static void main(String[] args) {
    TestStop testStop = new TestStop();
    new Thread(testStop).start();

    for (int i = 0; i < 100; i++) {
      System.out.println("main: " + i);
      if (i == 90) {
        testStop.stop();
        System.out.println("testStop线程停止了,main线程还在运行");
      }
    }
  }
}
