/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-03 17:53:58
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 14:03:05
 * @FilePath: \Java\Java\src\main\java\learn\net\GetURL.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class GetURL {
  public static void main(String[] args) throws Exception {
    // 1.设置URL和文件路径
    URL url = new URL("https://cdn.jsdelivr.net/gh/Weidows/Images/img/divider.png");
    String path = "Java/src/main/java/twenty_one/net/";
    String fileName = url.getPath().substring(url.getPath().lastIndexOf('/') + 1);

    /**
     * ! URL类用法
     *
      System.out.println(url.getProtocol());
      System.out.println(url.getHost());
      System.out.println(url.getPort());
      System.out.println(url.getPath());
      System.out.println(url.getFile());
      System.out.println(url.getQuery());
    *
      https
      cdn.jsdelivr.net
      /gh/Weidows/Images@master/img/divider.png
      /gh/Weidows/Images@master/img/divider.png
      null
    */

    // 2.输入输出流
    InputStream openStream = url.openStream();
    FileOutputStream fileOutputStream = new FileOutputStream(new File(path + fileName));

    // 3.传输数据
    byte[] bytes = new byte[1024];
    int length;
    while ((length = openStream.read(bytes)) != -1) {
      fileOutputStream.write(bytes, 0, length);
    }

    // 4.关闭连接
    fileOutputStream.close();
    openStream.close();
  }
}
