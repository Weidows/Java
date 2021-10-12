/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-22 00:22:25
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-22 00:29:20
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\multi_thread\sync\ticket.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.sync;

public class Ticket implements Runnable {
  private int ticketNums = 10; //票数
  boolean flag = true; //外部停止方法

  @Override
  public void run() {
    while (flag) {
      buy();
    }
  }

  public synchronized void buy() {
    //判断是否有票
    if (ticketNums <= 0) {
      flag = false;
      return;
    }
    //模拟延时
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + "-->得到倒数第" + ticketNums-- + "票");
  }

  public static void main(String[] args) {
    Ticket ticket = new Ticket();

    new Thread(ticket, "小明").start();
    new Thread(ticket, "老师").start();
    new Thread(ticket, "黄牛").start();
  }
}
