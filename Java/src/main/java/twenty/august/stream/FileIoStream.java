/*
 * @Author: Weidows
 * @Date: 2020-08-01 08:39:43
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-20 13:06:46
 * @FilePath: \Weidows\Java\src\main\java\twenty\august\stream\FileIoStream.java
 */
package twenty.august.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIoStream {
  /**
   * * 文件流: FileInputStream & FileOutputStream(实际工程不会使用了)
   *  更常用的是在内存数据或通信数据上建立的流(Exp.数据库二进制io,网络端口通信)
   *  具体的io会具有更专业的特殊的类(Exp.配置文件,日志文件)
   */
  public static void main(String[] args) {
    byte[] buf = new byte[10];
    for (int i = 0; i < buf.length; i++) {
      buf[i] = (byte) i;
    }
    try {
      FileOutputStream out = new FileOutputStream("./Java/src/main/java/twenty/august/stream/a.dat"); //二进制input,即使写入.txt也打不开
      out.write(buf);
      out.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
