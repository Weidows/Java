/*
 * @Author: Weidows
 * @Date: 2020-08-01 12:33:50
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-27 23:54:27
 * @FilePath: \Weidows\Java\src\main\java\twenty\august\stream\StreamFilter.java
 */
package twenty.august.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamFilter {
  /**
   *  流过滤器是以套娃形式把一种数据流转变成其他类型的方法
   */
  public static void main(String[] args) {
    byte[] byteArray = new byte[10];
    int[] intArray = new int[10];
    for (int i = 0; i < byteArray.length; i++) {
      byteArray[i] = (byte) i;
      intArray[i] = i;
    }
    try {
      // ! 分行模式
      FileOutputStream fileOut = new FileOutputStream("./Java/src/main/java/twenty/august/stream/b.dat");
      BufferedOutputStream bufferOut = new BufferedOutputStream(fileOut);//*缓冲
      DataOutputStream dataOut = new DataOutputStream(bufferOut);// *可以io byte类型以外的数据

      // ! 组合模式
      DataOutputStream dataOut_1 = new DataOutputStream(
        new BufferedOutputStream(new FileOutputStream("./Java/src/main/java/twenty/august/stream/c.dat")));

      // ! 写入数据
      dataOut.write(byteArray);
      for (int idx : intArray) { // 无法快捷写入,只能遍历
        dataOut.writeInt(intArray[idx]);
        dataOut_1.writeInt(intArray[idx]);
      }
      dataOut.close(); // *输出流关闭
      dataOut_1.close();

      // ! 读取数据
      DataInputStream dataIn = new DataInputStream(
          new BufferedInputStream(new FileInputStream("./Java/src/main/java/twenty/august/stream/c.dat")));
      //*此处再通过dataIn.read()读取数据,可以是readInt(),readChar()...
      dataIn.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
