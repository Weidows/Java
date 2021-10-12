/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-24 17:23:02
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-24 18:52:25
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\multi_thread\prime\TestLock.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.prime;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock implements Runnable {
  int ticketNums = 10;
  private final ReentrantLock lock = new ReentrantLock(); // 定义Lock锁

  @Override
  public void run() {
    while (true) {
      try {
        lock.lock(); // 加锁
        if (ticketNums > 0) {
          System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "票");
        } else {
          break;
        }
      } finally {
        lock.unlock(); // 解锁
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    TestLock testLock = new TestLock();

    new Thread(testLock, "a").start();
    new Thread(testLock, "b").start();
    new Thread(testLock, "c").start();
  }
}
