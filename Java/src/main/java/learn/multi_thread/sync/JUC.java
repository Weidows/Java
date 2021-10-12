/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-22 20:28:07
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-22 22:14:51
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\multi_thread\sync\JUC.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.sync;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class JUC {
  public static void main(String[] args) {
    List<String> list = new CopyOnWriteArrayList<String>();

    for (int i = 0; i < 10000; i++) {
      new Thread(() -> {
        list.add(Thread.currentThread().getName());
      }).start();
    }

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(list.size());//输出：10000
  }
}
