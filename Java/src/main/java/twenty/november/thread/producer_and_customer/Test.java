/*
 * @Author: Weidows
 * @Date: 2020-11-03 23:38:42
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-10 18:41:03
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\thread\producer_and_customer\Test.java
 * @Description:生产者与消费者模型
 */
package twenty.november.thread.producer_and_customer;

class Clerk {
  public int productNumber; // 售货员手中的商品数
}

public class Test {
  public static void main(String[] args) {
    Clerk clerk = new Clerk();

    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (clerk) {
          while (true) { //一直生产
            if (clerk.productNumber == 0) {
              System.out.println("产品为0, 开始生产");
              while (clerk.productNumber < 5) {
                System.out.println("库存: " + clerk.productNumber++);
                try {
                  Thread.sleep(500);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
              System.out.println("产品为5, 生产结束");
              clerk.notify();
            } else { //商品数不为0时让clerk等待
              try {
                clerk.wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          }
        }
      }
    }, "生产者").start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (clerk) {
          while (true) { //一直消费
            if (clerk.productNumber == 5) {
              System.out.println("产品为5,开始消费");
              while (clerk.productNumber > 0) {
                System.out.println("库存: " + clerk.productNumber--);
                try {
                  Thread.sleep(500);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
              clerk.notify(); //唤醒生产者
            } else {
              try {
                clerk.wait(); //消费者等待
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          }
        }
      }
    }, "消费者").start();
  }
}
