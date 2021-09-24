/*
 * @Author: Weidows
 * @Date: 2020-11-03 19:20:18
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-10 18:27:22
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\thread\bank\Account.java
 * @Description:
 */
package twenty.november.thread.bank;

import java.math.BigDecimal;

public class Account {
  private BigDecimal money = new BigDecimal(3000);
  // String name; //如果在这里直接获取线程名,那线程名都变成main,而且也不能让name在这里定义

  /**
   * <ul><li>同步锁</li></ul>
   * <p>一个线程执行这个方法时锁住这个对象(account)
   * <p>所有其他涉及这个对象的线程等待这个方法执行完
   *!<p>锁的是对象,不是方法(weixin和zhifubao线程都用到account对象,于是在weixin.run().draw()运行时,zhifubao线程等待)
   * <p>不同的对象用不同的锁,但如果方法是static的,那此方法对于所有对象都锁住
   */
  public synchronized void draw(int money) {
    String name = Thread.currentThread().getName();
    BigDecimal demandMoney = new BigDecimal(money);

    this.threadConnect(name); // 测试线程间的通信(微信与支付宝运行顺序)

    System.out.println(name + "\t账户原有金额: " + this.money);
    System.out.println(name + "\t取款金额: " + money);

    if (this.money.compareTo(demandMoney) == -1) {
      System.out.println(name + "\t账户余额不足");
    } else {
      // 注意BigDecimal做运算返回值需要接一下(不接的话没效果)
      this.money = this.money.subtract(demandMoney);
      System.out.println(name + "\t取款后的余额" + this.money);
    }
    /**
     * 唤醒这个对象所开的线程(也就是上面wait()的线程"微信")
     * 如果有多个线程等待唤醒,则唤醒其中随机一个线程.
     */
    this.notify();
  }

  private void test() {
    synchronized (this) {
      /**
       * 对代码块进行同步锁,不同方法中的多个代码块共享同一个锁
       * (一锁连着其他方法中的代码块也给锁住)
       * 同步代码块只能写在方法中,不能直接写在类里
       */
    }
  }

  /**
   * @description: 线程通信
   * <p>判断线程是否是"微信",是的话让他wait(),让正在排队的线程执行
   * @param {String} name
   * @return {*}
   */
  private void threadConnect(String name) {
    if (name.equals("微信")) {
      try {
        /**
         * 使当前线程进入等待状态,直到另一个线程对此对象发出.notify()为止
         * ! .wait() .notify() .notifyAll()这三个方法只能在有同步锁的方法或者代码块中执行
         */
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
