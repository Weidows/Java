/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-22 00:32:08
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 14:02:34
 * @FilePath: \Java\Java\src\main\java\learn\multi_thread\sync\Bank.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.sync;

import java.math.BigDecimal;

public class Bank {
  public static void main(String[] args) {
    Account account = new Account(new BigDecimal(100), "我的账户");

    DrawingChannel a = new DrawingChannel(account, new BigDecimal(50), "A");
    DrawingChannel b = new DrawingChannel(account, new BigDecimal(100), "B");

    a.start();
    b.start();
  }
}

//账户
class Account {
  BigDecimal balance;//余额
  final String name; //卡名

  public Account(BigDecimal balance, String name) {
    this.balance = balance;
    this.name = name;
  }
}

/**
 * 银行：模拟取款
 * * 这里之所以没用实现Runnable接口的方式是为了调用Thread类中一些方法
 */
class DrawingChannel extends Thread {
  final Account account; //账户
  BigDecimal drawingMoney; //取了多少钱
  BigDecimal nowMoney; //现在手里有多少钱

  public DrawingChannel(Account account, BigDecimal drawingMoney, String name) {
    super(name);
    this.account = account;
    this.drawingMoney = drawingMoney;
    this.nowMoney = new BigDecimal(0);
  }

  @Override
  public void run() {
    synchronized (account) {
      //判断有没有钱
      if (account.balance.compareTo(drawingMoney) < 0) {
        System.out.println(account.name + "钱不够" + drawingMoney + "," + this.getName() + "无法取走");
        return;
      }

      // 放大错误
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      draw();
    }
  }

  private void draw() {
    //卡内余额 = 余额 - 取的钱
    account.balance = account.balance.subtract(drawingMoney);
    System.out.println(this.getName() + "取走" + drawingMoney);

    //手里的钱
    nowMoney = nowMoney.add(drawingMoney);

    System.out.println(account.name + "余额为：" + account.balance);
    System.out.println(this.getName() + "手里的钱：" + nowMoney);
  }
}
