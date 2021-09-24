/*
 * @Author: Weidows
 * @Date: 2020-08-01 13:42:21
 * @LastEditors: Weidows
 * @LastEditTime: 2020-08-06 16:20:23
 * @FilePath: \Weidows\Java\src\main\java\twenty\august\text_io_stream\textStream.java
 */
package twenty.august.text_io_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * * 二进制用的是Stream,处理文本io采用Reader/Writer(处理Unicode字符集)
 *
 */
public class TextStream {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    /**
     * * 由于编码问题很多文件无法直接用Reader/Writer处理,需要在中间借用Stream
     *  OutputStream是Stream与Writer之间的桥梁
     */
    try {
      //!输出流到文件
      PrintWriter out = new PrintWriter(new BufferedWriter(
          new OutputStreamWriter(new FileOutputStream("./Java/src/main/java/twenty/august/Text_io_stream/a.txt"))));
      out.println(new String(in.next()));//!由于utf8...汉字乱码
      in.close();
      out.close();

      //!读取文件
      BufferedReader input = new BufferedReader(new InputStreamReader(
          new FileInputStream("./Java/src/main/java/twenty/august/Text_io_stream/TextStream.java")));
      String line;
      while ((line = input.readLine()) != null) {
        System.out.println(line);
      }
      input.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
