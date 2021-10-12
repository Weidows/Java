/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-21 23:00:41
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-21 23:09:57
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\multi_thread\TestState.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.basic;

public class TestState {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("///");
    });

    //观察状态
    Thread.State state = thread.getState();
    System.out.println(state); //NEW

    //观察后启动
    thread.start(); //启动线程
    state = thread.getState();
    System.out.println(); //Run

    while (state != Thread.State.TERMINATED) { //只要线程不停止，就一直输出状态
      Thread.sleep(100);
      state = thread.getState(); //更新线程状态
      System.out.println(state); //输出状态

      //thread.start();   报错，因为已经死亡的线程不能再启动
    }
  }
}
