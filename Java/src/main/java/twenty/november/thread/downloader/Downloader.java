/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-11 01:27:01
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-11 10:33:30
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\thread\downloader\Downloader.java
 * @Description:练习多线程,实现多线程下载图片
 * @!: *********************************************************************
 */
package twenty.november.thread.downloader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class Downloader implements Runnable {
  private String url;
  private String fileName;

  public Downloader(String url, String fileName) {
    this.url = url;
    this.fileName = fileName;
  }

  @Override
  public void run() {
    try {
      FileUtils.copyURLToFile(new URL(url), new File(fileName));
      System.out.println("Download finished.");
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Thread(new Downloader("https://cdn.jsdelivr.net/gh/Weidows/Images/img/divider.png",
        "./Java/src/main/java/twenty/november/thread/downloader/1.png")).start();
    new Thread(new Downloader("https://cdn.jsdelivr.net/gh/Weidows/Images/img/divider.png",
        "./Java/src/main/java/twenty/november/thread/downloader/2.png")).start();
  }
}
