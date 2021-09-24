/*
 * @Author: Weidows
 * @Date: 2020-11-03 17:17:15
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-11 01:22:38
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\thread\basic\TestRunnable.java
 * @Description:implements Runnable
 */
package twenty.november.thread.basic;

public class TestRunnable implements Runnable {
  int count = 0;

  @Override
  public void run() {
    for (int i = 0; i < 5; i++, count++) {
      /**
       * 如果线程没指定名称,系统会给出默认名称,类似"Thread-0","Thread-1"
       */
      System.out.println("线程: " + Thread.currentThread().getName() + "\tcount=" + count);
    }
  }
}
