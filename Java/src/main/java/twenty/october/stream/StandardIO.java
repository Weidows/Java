/*
 * @Author: Weidows
 * @Date: 2020-10-31 00:14:41
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-31 14:49:30
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\stream\StandardIO.java
 * @Description:标准输入输出
 * InputStream && OutputStream
 * InputStreamReader && OutputStreamWriter
 */
package twenty.october.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class StandardIO {
  public static void testInputStreamReader() throws Exception {
    //System.in返回InputStream(标准输入)类型对象
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(input);
    String string = ""; //临时接收数据的字符串
    while ((string = buffer.readLine()) != null) {
      System.out.println(string);
    }
    buffer.close();
    input.close();
  }

  public static void testOutputStreamWriter(String outputPath) throws Exception {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new FileWriter(outputPath));
    String string = null;
    while ((string = input.readLine()) != null) {
      if (string.equals("over"))
        break;
      output.write(string + "\n");
    }
    output.flush();
    output.close();
    input.close();
    System.out.println("TestOutputStreamWriter done!");
  }

  public static void main(String[] args) {
    String path = "./Java/src/main/java/twenty/october/stream/5.txt";
    try {
      /**
       * 因为环境原因,标准输入流中文乱码,其他没问题
       */
      // testInputStreamReader();
      // testOutputStreamWriter(path);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
