/*
 * @Author: Weidows
 * @Date: 2020-08-01 07:57:28
 * @LastEditors: Weidows
 * @LastEditTime: 2020-08-01 10:19:51
 * @FilePath: \Weidows\Java\src\main\java\twenty\august\stream\IoStream.java
 */
package twenty.august.stream;

import java.io.IOException;
import java.util.Scanner;

public class IoStream {
  /**
   * *流的基础类 InputStream & OutputStream
   * @throws IOException //不知道干啥用的,throws生成的注释
   */
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);// 这里System.in输入流交给Scanner
    byte[] buffer = new byte[1024]; // ?创建字节数组
    // ? 数组初始化时就带有一个.length成员变量,而字符串需要调用.length()计算

    // ! 任何输入输出都是可能存在Exception
    try { // *throw声明并不会与try-catch冲突
      // *读取数据给buffer并返回字节数
      int len = System.in.read(buffer);

      // ? 用buffer里从0开始到len的数据构建String对象
      String s = new String(buffer, 0, len);

      // ! 这里存在编码格式bug,中文输出乱码
      System.out.println("读到了" + len + "字节\n" + "字符串为:" + s + "字符数:" + s.length());
    } catch (Exception e) {
      e.printStackTrace();
    }
    in.close();
  }
}
