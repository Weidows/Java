/*
 * @Author: Weidows
 * @Date: 2020-11-03 10:59:14
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-11 01:19:58
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\thread\basic\Test.java
 * @Description:main
 */
package twenty.november.thread.basic;

/**
 * 1和2方式创建线程对象都是要用Thread类的.run() / .start()
 * 继承子类是overwrite .run()
 * 实现接口是implements .run()
 * ! 实现更常用(避免单继承局限性,多线程间共享接口实现类的对象)
 */
public class Test {
  public static void main(String[] args) {
    //* 1. extends Thread
    // new TestExtends().start();

    //* 2.1 implements Runnable(线程能跑起来call的是Thread.start()不是.run())
    // new Thread(new TestRunnable()).start();
    //* 2.2 构造时指定线程名称
    // new Thread(new TestRunnable(), "TestRunnable_1").start();
    //* 2.3 指定线程名称
    // Thread t = new Thread(new TestRunnable());
    // t.setName("线程_1");
    // t.start();

    //* 3. 多个线程共享资源,线程间同步执行
    // TestRunnable testRunnable = new TestRunnable();
    // new Thread(testRunnable, "TestRunnable_1").start();
    // new Thread(testRunnable, "TestRunnable_2").start();

    //* 4. Thread优先级(int: 1~10, default:5)
    // Thread t = new Thread(new TestRunnable(), "线程_2");
    // t.setPriority(10);
    // System.out.println("Thread: " + t.getPriority());
    // t.start();

    /**
     * /5. .join()方法
     * 把t对象的Thread:线程_3的.run()在这里执行
     * 可以发现输出内容一定在两线之间
     */
    // Thread t = new Thread(new TestRunnable(), "线程_3");
    // t.start();
    // try {
    //   System.out.println("--------------------------------------------");
    //   t.join();
    //   System.out.println("--------------------------------------------");
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }

    //* 6. .sleep(int)  Thread睡眠int毫秒

    //* 7. .stop()  直接结束Thread

    //* 8. .isAlive() :boolean判断Thread是否存活
  }
}
