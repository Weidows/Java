/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-22 20:16:39
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-22 20:23:45
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\multi_thread\sync\TestList.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.sync;

import java.util.ArrayList;
import java.util.List;

public class TestList {
  public static void main(String[] args) throws InterruptedException {
    List<String> list = new ArrayList<String>();

    for (int i = 0; i < 10000; i++) {
      new Thread(() -> {
        synchronized (list) {
          list.add(Thread.currentThread().getName());
        }
      }).start();
    }
    Thread.sleep(3000); // 延时,为了等上面执行完毕
    System.out.println(list.size());//输出：10000
  }
}
