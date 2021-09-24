/*
 * @Author: Weidows
 * @Date: 2020-10-30 23:46:08
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-31 15:11:36
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\stream\TransformStream.java
 * @Description:转换流
 */
package twenty.october.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TransformStream {
  /**
   * @description: 通过制定字符编码格式读入
   * @param {String} inputPath
   * @param {String} codeFormat
   * @return {*}
   */
  public static void testInputStreamReader(String inputPath, String charsetName) throws Exception {
    InputStreamReader input = new InputStreamReader(new FileInputStream(inputPath), charsetName);
    char[] buffer = new char[100];
    int length = 0;
    while ((length = input.read(buffer)) != -1) {
      System.out.println(new String(buffer, 0, length));
    }
    input.close();
    System.out.println("TestInputStreamReader done!");
  }

  public static void testOutputStreamWriter(String outputPath, String text, String charsetName) throws Exception {
    OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(outputPath), charsetName);
    output.write(text);
    output.flush();
    output.close();
    System.out.println("TestOutputStreamWriter done!");
  }

  public static void main(String[] args) {
    String path = "./Java/src/main/java/twenty/october/stream/4.txt";
    try {
      /**
       * All tested,no errors.
       */
      // testInputStreamReader(path, "utf8");
      // testOutputStreamWriter(path,"我叫大家啊我的骄傲的","utf8");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
