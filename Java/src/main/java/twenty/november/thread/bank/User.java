/*
 * @Author: Weidows
 * @Date: 2020-11-03 21:03:56
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-03 23:16:00
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\thread\bank\User.java
 * @Description:
 */
package twenty.november.thread.bank;

public class User implements Runnable {
  Account account;
  int money;
  protected User(Account account,int money) {
    this.account = account;
    this.money = money;
  }

  @Override
  public void run() {
    account.draw(money);
  }
}
