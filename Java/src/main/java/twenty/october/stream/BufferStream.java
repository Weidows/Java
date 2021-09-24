/*
 * @Author: Weidows
 * @Date: 2020-10-29 23:17:55
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-30 23:55:44
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\stream\BufferStream.java
 * @Description: Buffer缓冲流
 */
package twenty.october.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @description: buffer是在内存中的数据,极大加快了io性能
 * @param {*}
 * @return {*}
 */
public class BufferStream {
  public static void testBufferedInputStream(String inputPath) throws Exception {
    FileInputStream input = new FileInputStream(inputPath);
    BufferedInputStream buffer = new BufferedInputStream(input);
    byte[] b = new byte[100];
    int length = 0;
    while ((length = buffer.read(b)) != -1) {
      System.out.println(new String(b, 0, length));
    }
    //? 关闭流时要跟堆栈一样,最后来的最先关
    buffer.close();
    input.close();
    System.out.println("testBufferedInputStream done!");
  }

  public static void testBufferedOutputStream(String text, String outputPath) throws Exception {
    FileOutputStream output = new FileOutputStream(outputPath);
    BufferedOutputStream buffer = new BufferedOutputStream(output);
    buffer.write(text.getBytes());
    buffer.flush();
    buffer.close();
    output.close();
    System.out.println("testBufferedOutputStream done!");
  }

  public static void copyFile(String inputPath, String outputPath) throws Exception {
    BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputPath));
    BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputPath));
    byte[] buffer = new byte[100];
    int length = 0;
    while ((length = input.read(buffer)) != -1) {
      output.write(buffer, 0, length);
    }
    output.flush();
    output.close();
    input.close();
    System.out.println("CopyFile done!");
  }

  public static void testBufferedReader(String inputPath) throws Exception {
    BufferedReader input = new BufferedReader(new FileReader(inputPath));
    char[] buffer = new char[100];
    int length = 0;
    while ((length = input.read(buffer)) != -1) {
      System.out.println(new String(buffer, 0, length));
    }
    input.close();
    System.out.println("testBufferedReader finished");
  }

  public static void testBufferedWriter(String text, String outputPath) throws Exception {
    BufferedWriter output = new BufferedWriter(new FileWriter(outputPath));
    output.write(text);
    output.flush();
    output.close();
    output.close();
    System.out.println("testBufferedWriter done!");
  }

  public static void copyWordFile(String inputPath, String outputPath) throws Exception {
    BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputPath));
    BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputPath));
    byte[] buffer = new byte[100];
    int length = 0;
    while ((length = input.read(buffer)) != -1) {
      output.write(buffer, 0, length);
    }
    output.flush();
    output.close();
    input.close();
    System.out.println("CopyFile done!");
  }

  public static void main(String[] args) {
    String inputPath = "./Java/src/main/java/twenty/october/stream/1.txt",
        outputPath = "./Java/src/main/java/twenty/october/stream/2.txt";
    try {
      /**
       * ! All tested, No errors.
       */
      // testBufferedInputStream(inputPath);
      // testBufferedOutputStream("helloworld", outputPath);
      // copyFile(inputPath, outputPath);

      // testBufferedReader(inputPath);
      // testBufferedWriter("helloworld", outputPath);
      // copyWordFile(inputPath, outputPath);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
