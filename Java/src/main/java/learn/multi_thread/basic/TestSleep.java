/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-19 18:04:34
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-19 18:12:34
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\multi_thread\TestSleep.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.basic;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class TestSleep {
  public static void main(String[] args) {
    try {
      // 十秒倒计时
      tenSecondsDown();

      // 每秒输出系统当前时间
      countTime();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void tenSecondsDown() throws InterruptedException {
    int num = 10;
    while (true) {
      Thread.sleep(1000);
      System.out.println(num--);
      if (num == 0)
        break;
    }
  }

  public static void countTime() {
    Date startTime = new Date(System.currentTimeMillis()); //获取系统当前时间
    while (true) {
      try {
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
        startTime = new Date(System.currentTimeMillis()); //更新当前时间
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
