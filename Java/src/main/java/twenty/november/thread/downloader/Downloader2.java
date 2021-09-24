/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-11 10:52:30
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-11 11:25:35
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\thread\downloader\Downloader2.java
 * @Description:Callable与Runnable区别为带有返回值类型,可以抛出异常
 * @!: *********************************************************************
 */
package twenty.november.thread.downloader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

public class Downloader2 implements Callable<Object> {
  private String url;
  private String fileName;

  @Override
  public Object call() throws MalformedURLException, IOException {
    FileUtils.copyURLToFile(new URL(url), new File(fileName));
    System.out.println(fileName + "下载完成");
    return null;
  }

  public Downloader2(String url, String fileName) {
    this.url = url;
    this.fileName = fileName;
  }

  public static void main(String[] args) {
    // 创建线程池
    ExecutorService ser = Executors.newFixedThreadPool(2);

    // 提交执行
    Future<Object> submit1 = ser
        .submit(new Downloader2("https://cdn.jsdelivr.net/gh/Weidows/Images/img/divider.png",
            "./Java/src/main/java/twenty/november/thread/downloader/1.png"));
    Future<Object> submit2 = ser
        .submit(new Downloader2("https://cdn.jsdelivr.net/gh/Weidows/Images/img/divider.png",
            "./Java/src/main/java/twenty/november/thread/downloader/2.png"));

    // 获取结果
    try {
      Object result1 = submit1.get();
      Object result2 = submit2.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    // 关闭服务
    ser.shutdown();
  }
}
