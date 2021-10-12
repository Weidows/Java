/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-22 22:54:42
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-24 17:11:33
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\multi_thread\sync\DeadLock.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.sync;

//死锁：多个线程互相抱着对方需要的资源
public class DeadLock {
  public static void main(String[] args) {
    Makeup m1 = new Makeup(0, "小黑");
    Makeup m2 = new Makeup(1, "小白");

    m1.start();
    m2.start();
  }
}

// 口红
class Lipstick {
}

// 镜子
class Mirror {
}

// 化妆
class Makeup extends Thread {
  // 需要的资源只有一份，用static来保证只有一份
  static final Lipstick lipstick = new Lipstick();
  static final Mirror mirror = new Mirror();

  int choice; // 选择
  String name; // 使用化妆品的人

  public Makeup(int choice, String name) {
    this.choice = choice;
    this.name = name;
  }

  @Override
  public void run() {
    // 化妆
    try {
      makeup();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  // 化妆，互相持有对方的锁，就是需要拿到对方的资源
  private void makeup() throws InterruptedException {
    if (choice == 0) {
      synchronized (lipstick) { // 获得口红的锁
        System.out.println(this.name + "获得口红的锁");
        Thread.sleep(1000);
      }
      synchronized (mirror) { // 一秒钟后想获得镜子的锁
        System.out.println(this.name + "获得镜子的锁");
      }
    } else {
      synchronized (mirror) { // 获得镜子的锁
        System.out.println(this.name + "获得镜子的锁");
        Thread.sleep(2000);
      }
      synchronized (lipstick) { // 两秒钟后想获得口红的锁
        System.out.println(this.name + "获得口红的锁");
      }
    }
  }
}
