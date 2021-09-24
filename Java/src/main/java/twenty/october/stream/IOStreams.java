/*
 * @Author: Weidows
 * @Date: 2020-10-29 08:31:33
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-31 15:30:43
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\stream\IOStreams.java
 */
package twenty.october.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class IOStreams {

  public static void main(String[] args) {
    /**
     * ! All tested - No exception.
     *  <p>注意文件当指定目录有同名文件时,写入操作会覆盖那个文件.
     *  <p>读取文件时指定目录不存在那个文件的话会报错.
     */
    String inputPath = "./Java/src/main/java/twenty/october/stream/1.txt",
        outputPath = "./Java/src/main/java/twenty/october/stream/2.txt";
    // ByteStream.testFileInputStream(inputPath);
    // ByteStream.testFileOutputStream(outputPath);
    // ByteStream.copyFile(outputPath, "./Java/src/main/java/twenty/october/stream/3.txt");

    // FileReaderWriter.testFileReader(inputPath);
    // FileReaderWriter.testFileWriter("我叫doawidjafnanwn", outputPath);
    // FileReaderWriter.copyFile(inputPath, outputPath);
  }
}

/**
 * @description: 字节IO流
 * @param {*}
 * @return {*}
 */
class ByteStream {
  public static void testFileInputStream(String inputPath) {
    try {
      FileInputStream input = new FileInputStream(inputPath);
      byte[] b = new byte[10]; //因为是字节流,只能io byte类型数据
      int length = 0; //设置字节长度
      /**
       * <p>这步是把文件中的数据读取到b[]中
       * <p>length是为了控制不输出b中的空数据
       * <p>通过while()使得即使b[]容不下数据也能一组一组的输出直到输完
       */
      while ((length = input.read(b)) != -1) {
        System.out.println(new String(b, 0, length));
      }
      input.close();
      System.out.println("FileInputStream finished!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void testFileOutputStream(String outputPath) {
    try {
      FileOutputStream output = new FileOutputStream(outputPath);
      String str = "我叫Weidows";
      output.write(str.getBytes()); //把数据写入(内存中)
      output.flush(); //把内存中的数据写入硬盘
      output.close(); //关闭流
      System.out.println("FileOutputStream finished!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * @description: 文件复制
   * <p>字节流非常通用,不仅能复制文本类型文件,比如图片,压缩包,视频等等也可以复制
   * @param {String} inputPath
   * @param {String} outputPath
   * @return {*}
   */
  public static void copyFile(String inputPath, String outputPath) {
    try {
      FileInputStream input = new FileInputStream(inputPath);
      FileOutputStream output = new FileOutputStream(outputPath);
      byte[] buffer = new byte[100];
      int length = 0;
      while ((length = input.read(buffer)) != -1) {
        output.write(buffer, 0, length); //copy to mem
      }
      input.close();
      output.flush();
      output.close();
      System.out.println("File copy done!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

/**
 * @description: 字符IO流
 * @param {*}
 * @return {*}
 */
class FileReaderWriter {
  public static void testFileReader(String inputPath) {
    try {
      FileReader input = new FileReader(inputPath);
      char[] buffer = new char[10];
      int length = 0;
      while ((length = input.read(buffer)) != -1) {
        System.out.println(new String(buffer, 0, length));
      }
      input.close();
      System.out.println("FileReader done!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void testFileWriter(String text, String outputPath) {
    try {
      FileWriter output = new FileWriter(outputPath);
      output.write(text);
      output.flush();
      output.close();
      System.out.println("FileWriter done!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * @description: 文件复制
   * <p>这个只能复制文本文件了,媒体文件和二进制文件都不可以
   * @param {*}
   * @return {*}
   */
  public static void copyFile(String inputPath, String outputPath) {
    try {
      FileReader input = new FileReader(inputPath);
      FileWriter output = new FileWriter(outputPath);
      char[] buffer = new char[100];
      int length = 0;
      while ((length = input.read(buffer)) != -1) {
        output.write(buffer, 0, length);
      }
      output.flush();
      input.close();
      output.close();
      System.out.println("CopyFile done!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
