/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-24 22:52:25
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-25 11:13:16
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\multi_thread\prime\TestThreadPool.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.multi_thread.prime;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
  public static void main(String[] args) {
    // 1.创建服务，创建线程池
    ExecutorService service = Executors.newFixedThreadPool(10); // 参数为线程池大小
    Runnable myThread = () -> {
      System.out.println(Thread.currentThread().getName());
    };
    Callable<String> myThread2 = () -> {
      return "Running in " + Thread.currentThread().getName();
    };

    // 执行:前五个是Runnable,后五个是Callable
    service.execute(myThread);
    service.execute(myThread);
    service.execute(myThread);
    service.execute(myThread);
    service.execute(myThread);
    try {
      System.out.println(service.submit(myThread2).get());
      System.out.println(service.submit(myThread2).get());
      System.out.println(service.submit(myThread2).get());
      System.out.println(service.submit(myThread2).get());
      System.out.println(service.submit(myThread2).get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    // 2.关闭连接
    service.shutdown();
  }
}

// class MyThread implements Runnable {
//   @Override
//   public void run() {
//     System.out.println(Thread.currentThread().getName());
//   }
// }

// class MyThread2 implements Callable {
//   @Override
//   public Object call() throws Exception {
//     return "Running in " + Thread.currentThread().getName();
//   }
// }
