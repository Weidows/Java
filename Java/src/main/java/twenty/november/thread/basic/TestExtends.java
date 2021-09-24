/*
 * @Author: Weidows
 * @Date: 2020-11-03 10:57:22
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-11 01:20:14
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\thread\basic\TestExtends.java
 * @Description:线程类
 */
package twenty.november.thread.basic;

public class TestExtends extends Thread {
  @Override
  public void run() {
    System.out.println("Running in TestThread.run()");
  }
}
