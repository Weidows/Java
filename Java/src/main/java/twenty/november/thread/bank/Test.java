/*
 * @Author: Weidows
 * @Date: 2020-11-03 21:00:34
 * @LastEditors: Weidows
 * @LastEditTime: 2020-12-13 22:50:35
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\thread\bank\Test.java
 * @Description:
 */
package twenty.november.thread.bank;

public class Test {
  public static void main(String[] args) {
    // 开户
    Account account = new Account();

    // 开线程
    Thread weixin = new Thread(new User(account, 2000), "微信");
    Thread zhifubao = new Thread(new User(account, 2000), "支付宝");
    weixin.start();
    zhifubao.start();
  }
}
